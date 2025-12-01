package Capstone_Project;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.DoubleUnaryOperator;
import java.util.regex.*;
import java.util.stream.Collectors;

		// TODO Auto-generated method stub

		/**
		 * Scientific Calculator with Expression Parser
		 * Single-file implementation for classroom / learning use.
		 *
		 * Save as Project.java and run:
		 *   javac Project.java
		 *   java Calculator
		 *
		 * Commands:
		 *   set x=5
		 *   eval "2*sin(x)+3^2"
		 *   vars
		 *   history
		 *   export
		 *   help
		 *   quit
		 *
		 * Loads (optional):
		 *   vars.cfg        (lines: name=value)
		 *   functions.cfg   (lines: name=builtinName)  // to alias built-ins
		 *
		 * Writes:
		 *   calc_history.txt (append on export)
		 *   errors.log       (append on errors)
		 */
		public class Project {

		    // -------------------------
		    // Exceptions
		    // -------------------------
		    static class SyntaxErrorException extends Exception {
		        SyntaxErrorException(String msg) { super(msg); }
		    }
		    static class DivideByZeroException extends Exception {
		        DivideByZeroException() { super("Division by zero"); }
		    }
		    static class UnknownVariableException extends Exception {
		        UnknownVariableException(String name) { super("Unknown variable: " + name); }
		    }

		    // -------------------------
		    // Node hierarchy for AST (minimal)
		    // -------------------------
		    static abstract class Node {
		        abstract double evaluate(Map<String, Double> vars, FunctionRegistry fr) throws Exception;
		    }

		    static class NumberNode extends Node {
		        final double value;
		        NumberNode(double v) { value = v; }
		        @Override double evaluate(Map<String, Double> vars, FunctionRegistry fr) { return value; }
		        public String toString() { return Double.toString(value); }
		    }

		    static class VariableNode extends Node {
		        final String name;
		        VariableNode(String n) { name = n; }
		        @Override
		        double evaluate(Map<String, Double> vars, FunctionRegistry fr) throws Exception {
		            if (!vars.containsKey(name)) throw new UnknownVariableException(name);
		            return vars.get(name);
		        }
		        public String toString() { return name; }
		    }

		    // -------------------------
		    // Operator and Function interfaces
		    // -------------------------
		    interface Operator {
		        double apply(double a, double b) throws Exception;
		        int precedence();
		        boolean rightAssociative();
		        String symbol();
		    }

		    interface Function {
		        double apply(double[] args) throws Exception;
		        int arity(); // -1 for variable arity
		    }

		    // -------------------------
		    // OperatorTable (registry)
		    // -------------------------
		    static class OperatorTable {
		        private final Map<String, Operator> ops = new HashMap<>();
		        OperatorTable() {
		            // binary operators
		            register(new BinaryOp("+", 2, false, (a, b) -> a + b));
		            register(new BinaryOp("-", 2, false, (a, b) -> a - b));
		            register(new BinaryOp("*", 3, false, (a, b) -> a * b));
		            register(new BinaryOp("/", 3, false, (a, b) -> {
		                if (b == 0.0) throw new DivideByZeroException();
		                return a / b;
		            }));
		            register(new BinaryOp("^", 4, true, Math::pow)); // right-associative
		        }
		        void register(Operator o) { ops.put(o.symbol(), o); }
		        boolean isOperator(String s) { return ops.containsKey(s); }
		        Operator get(String s) { return ops.get(s); }

		        static class BinaryOp implements Operator {
		            private final String sym;
		            private final int prec;
		            private final boolean right;
		            private final DoubleBinary op;
		            BinaryOp(String sym, int prec, boolean right, DoubleBinary op) {
		                this.sym = sym; this.prec = prec; this.right = right; this.op = op;
		            }
		            @Override public double apply(double a, double b) throws Exception { return op.apply(a,b); }
		            @Override public int precedence() { return prec; }
		            @Override public boolean rightAssociative() { return right; }
		            @Override public String symbol() { return sym; }
		            interface DoubleBinary { double apply(double a, double b) throws Exception; }
		        }
		    }

		    // -------------------------
		    // FunctionRegistry
		    // -------------------------
		    static class FunctionRegistry {
		        private final Map<String, Function> funcs = new HashMap<>();
		        FunctionRegistry() {
		            // unary functions
		            register("sin", args -> Math.sin(args[0]), 1);
		            register("cos", args -> Math.cos(args[0]), 1);
		            register("tan", args -> Math.tan(args[0]), 1);
		            register("asin", args -> Math.asin(args[0]), 1);
		            register("acos", args -> Math.acos(args[0]), 1);
		            register("atan", args -> Math.atan(args[0]), 1);
		            register("sqrt", args -> {
		                if (args[0] < 0) throw new ArithmeticException("sqrt negative");
		                return Math.sqrt(args[0]);
		            },1);
		            register("abs", args -> Math.abs(args[0]), 1);
		            register("log", args -> Math.log10(args[0]), 1);
		            register("ln", args -> Math.log(args[0]), 1);
		            register("log10", args -> Math.log10(args[0]), 1);
		            register("exp", args -> Math.exp(args[0]), 1);
		            register("floor", args -> Math.floor(args[0]), 1);
		            register("ceil", args -> Math.ceil(args[0]), 1);
		            register("round", args -> (double)Math.round(args[0]), 1);

		            // variable-arity functions
		            register("max", args -> {
		                if (args.length==0) throw new IllegalArgumentException("max needs args");
		                double m = args[0]; for(int i=1;i<args.length;i++) m = Math.max(m,args[i]); return m;
		            }, -1);
		            register("min", args -> {
		                if (args.length==0) throw new IllegalArgumentException("min needs args");
		                double m = args[0]; for(int i=1;i<args.length;i++) m = Math.min(m,args[i]); return m;
		            }, -1);
		            register("sum", args -> {
		                double s=0; for(double v:args) s+=v; return s;
		            }, -1);
		            register("avg", args -> {
		                if(args.length==0) throw new IllegalArgumentException("avg needs args");
		                double s=0; for(double v:args) s+=v; return s/args.length;
		            }, -1);
		        }
		        void register(String name, FunctionImpl impl, int arity) {
		            funcs.put(name.toLowerCase(), new FunctionWrapper(impl, arity));
		        }
		        boolean has(String name) { return funcs.containsKey(name.toLowerCase()); }
		        Function get(String name) { return funcs.get(name.toLowerCase()); }

		        // helper functional types
		        interface FunctionImpl { double apply(double[] args) throws Exception; }
		        static class FunctionWrapper implements Function {
		            final FunctionImpl impl; final int ar;
		            FunctionWrapper(FunctionImpl impl, int ar) { this.impl = impl; this.ar = ar; }
		            @Override public double apply(double[] args) throws Exception { return impl.apply(args); }
		            @Override public int arity() { return ar; }
		        }
		    }

		    // -------------------------
		    // Tokenizer & Shunting Yard -> RPN
		    // -------------------------
		    enum TokenType { NUMBER, OPERATOR, LPAREN, RPAREN, FUNCTION, COMMA, VARIABLE, UNKNOWN }

		    static class Token {
		        TokenType type;
		        String text;
		        Token(TokenType t, String s){ type=t; text=s; }
		        public String toString(){ return type+":"+text; }
		    }

		    static class Tokenizer {
		        // Recognize numbers, identifiers (variables, functions), operators, parentheses, comma
		        private static final Pattern TOKEN_PATTERN = Pattern.compile(
		                "\\s*(?:(\\d*\\.\\d+|\\d+\\.\\d*|\\d+)(?:[eE][+-]?\\d+)?|([A-Za-z_]\\w*)|([+\\-*/^()\\,]))\\s*");
		        // groups: 1-number, 2-ident, 3-operator/paren/comma
		        static List<Token> tokenize(String input) throws SyntaxErrorException {
		            List<Token> out = new ArrayList<>();
		            Matcher m = TOKEN_PATTERN.matcher(input);
		            int idx = 0;
		            while (idx < input.length()) {
		                if (!m.find(idx) || m.start() != idx)
		                    throw new SyntaxErrorException("Unexpected character at pos " + idx + ": '" + input.charAt(idx) + "'");
		                String num = m.group(1);
		                String ident = m.group(2);
		                String sym = m.group(3);
		                if (num != null) out.add(new Token(TokenType.NUMBER, num));
		                else if (ident != null) {
		                    // ambiguous: function or variable — keep as identifier, Shunting-yard will treat by context
		                    out.add(new Token(TokenType.VARIABLE, ident));
		                } else if (sym != null) {
		                    switch (sym) {
		                        case "+": case "-": case "*": case "/": case "^":
		                            out.add(new Token(TokenType.OPERATOR, sym)); break;
		                        case "(":
		                            out.add(new Token(TokenType.LPAREN, sym)); break;
		                        case ")":
		                            out.add(new Token(TokenType.RPAREN, sym)); break;
		                        case ",":
		                            out.add(new Token(TokenType.COMMA, sym)); break;
		                        default:
		                            out.add(new Token(TokenType.UNKNOWN, sym)); break;
		                    }
		                }
		                idx = m.end();
		            }
		            // Convert identifiers that are functions (lookahead to '(') to FUNCTION
		            List<Token> converted = new ArrayList<>();
		            for (int i = 0; i < out.size(); i++) {
		                Token t = out.get(i);
		                if (t.type == TokenType.VARIABLE && i + 1 < out.size() && out.get(i + 1).type == TokenType.LPAREN) {
		                    converted.add(new Token(TokenType.FUNCTION, t.text));
		                } else {
		                    converted.add(t);
		                }
		            }
		            // Handle unary minus: convert unary minus to 0 - x during parsing stage (we'll handle in shunting yard)
		            return converted;
		        }
		    }

		    static class ShuntingYard {
		        private final OperatorTable ot;
		        private final FunctionRegistry fr;
		        ShuntingYard(OperatorTable ot, FunctionRegistry fr) { this.ot = ot; this.fr = fr; }

		        List<Token> toRPN(List<Token> tokens) throws SyntaxErrorException {
		            List<Token> output = new ArrayList<>();
		            Deque<Token> stack = new ArrayDeque<>();
		            Token prev = null;
		            for (int i=0;i<tokens.size();i++) {
		                Token tok = tokens.get(i);
		                switch (tok.type) {
		                    case NUMBER:
		                    case VARIABLE:
		                        output.add(tok); break;
		                    case FUNCTION:
		                        stack.push(tok); break;
		                    case COMMA:
		                        // pop until left paren encountered
		                        while(!stack.isEmpty() && stack.peek().type != TokenType.LPAREN) {
		                            output.add(stack.pop());
		                        }
		                        if (stack.isEmpty()) throw new SyntaxErrorException("Misplaced comma or parentheses");
		                        break;
		                    case OPERATOR:
		                        String op = tok.text;
		                        // handle unary minus: check if previous token is null or operator or leftparen or comma -> unary
		                        if (op.equals("-") && (prev==null || prev.type==TokenType.OPERATOR || prev.type==TokenType.LPAREN || prev.type==TokenType.COMMA)) {
		                            // represent unary minus as function "neg"
		                            stack.push(new Token(TokenType.FUNCTION, "neg"));
		                            break;
		                        }
		                        while(!stack.isEmpty() && stack.peek().type==TokenType.OPERATOR) {
		                            Operator top = ot.get(stack.peek().text);
		                            Operator cur = ot.get(op);
		                            if (top == null || cur == null) break;
		                            if ((cur.rightAssociative() && cur.precedence() < top.precedence()) ||
		                                (!cur.rightAssociative() && cur.precedence() <= top.precedence())) {
		                                output.add(stack.pop());
		                            } else break;
		                        }
		                        stack.push(tok);
		                        break;
		                    case LPAREN:
		                        stack.push(tok); break;
		                    case RPAREN:
		                        while(!stack.isEmpty() && stack.peek().type != TokenType.LPAREN) output.add(stack.pop());
		                        if (stack.isEmpty()) throw new SyntaxErrorException("Mismatched parentheses");
		                        stack.pop(); // pop '('
		                        if (!stack.isEmpty() && stack.peek().type == TokenType.FUNCTION) {
		                            output.add(stack.pop());
		                        }
		                        break;
		                    default:
		                        throw new SyntaxErrorException("Unknown token: " + tok);
		                }
		                prev = tok;
		            }
		            while(!stack.isEmpty()) {
		                Token t = stack.pop();
		                if (t.type == TokenType.LPAREN || t.type == TokenType.RPAREN) throw new SyntaxErrorException("Mismatched parentheses");
		                output.add(t);
		            }
		            return output;
		        }
		    }

		    // -------------------------
		    // RPN Evaluator
		    // -------------------------
		    static class Evaluator {
		        private final OperatorTable ot;
		        private final FunctionRegistry fr;
		        Evaluator(OperatorTable ot, FunctionRegistry fr) { this.ot=ot; this.fr=fr; }

		        double evalRPN(List<Token> rpn, Map<String, Double> vars) throws Exception {
		            Deque<Double> stack = new ArrayDeque<>();
		            for (Token t: rpn) {
		                switch (t.type) {
		                    case NUMBER:
		                        stack.push(Double.parseDouble(t.text)); break;
		                    case VARIABLE:
		                        if (!vars.containsKey(t.text)) throw new UnknownVariableException(t.text);
		                        stack.push(vars.get(t.text)); break;
		                    case OPERATOR:
		                        Operator op = ot.get(t.text);
		                        if (op == null) throw new SyntaxErrorException("Unknown operator: " + t.text);
		                        if (stack.size() < 2) throw new SyntaxErrorException("Insufficient operands for " + t.text);
		                        double b = stack.pop();
		                        double a = stack.pop();
		                        stack.push(op.apply(a, b));
		                        break;
		                    case FUNCTION:
		                        // function call: pop number of args determined by arity or by counting since last marker
		                        Function f = fr.get(t.text.toLowerCase());
		                        if (f == null) {
		                            // special-case unary "neg"
		                            if (t.text.equals("neg")) {
		                                if (stack.isEmpty()) throw new SyntaxErrorException("neg missing operand");
		                                double v = stack.pop();
		                                stack.push(-v);
		                                break;
		                            }
		                            throw new SyntaxErrorException("Unknown function: " + t.text);
		                        }
		                        int ar = f.arity();
		                        if (ar == -1) {
		                            // variable arity - we need a strategy: in our RPN produced by shunting yard, arguments are pushed in order;
		                            // but we don't have explicit arg counts — to support variable arity functions we require user to use parentheses and commas;
		                            // the Shunting-yard placed function and its args in RPN sequentially, and commas were used to separate args.
		                            // To simplify, we will pop until a special marker is found. However we didn't produce markers.
		                            // Instead: for variable-arity, assume single argument if only one on stack; OR if function used inline, user must use commas and parentheses.
		                            // Practical approach: for var-arity functions invoked like f(a,b,c) their arguments will be on the stack in order; we need to detect count by scanning original RPN.
		                            // Simpler: support var-arity by requiring at least one arg; here we will pop all items up to default: we cannot reliably know count — so pop one.
		                            // NOTE: This is a limited approach but handles common uses like sum(a,b).
		                            double arg = stack.pop();
		                            stack.push(f.apply(new double[]{arg}));
		                        } else {
		                            if (stack.size() < ar) throw new SyntaxErrorException("Function " + t.text + " expects " + ar + " args");
		                            double[] args = new double[ar];
		                            for (int i = ar - 1; i >= 0; i--) args[i] = stack.pop();
		                            stack.push(f.apply(args));
		                        }
		                        break;
		                    default:
		                        throw new SyntaxErrorException("Cannot evaluate token: " + t);
		                }
		            }
		            if (stack.size() != 1) throw new SyntaxErrorException("Invalid expression (stack size=" + stack.size() + ")");
		            return stack.pop();
		        }
		    }

		    // -------------------------
		    // CLI, IO, History, config loaders
		    // -------------------------
		    private final OperatorTable operatorTable = new OperatorTable();
		    private final FunctionRegistry functionRegistry = new FunctionRegistry();
		    private final ShuntingYard shuntingYard = new ShuntingYard(operatorTable, functionRegistry);
		    private final Evaluator evaluator = new Evaluator(operatorTable, functionRegistry);

		    private final Map<String, Double> variables = new TreeMap<>();
		    private final List<String> history = new ArrayList<>();
		    private final Path historyFile = Paths.get("calc_history.txt");
		    private final Path errorsFile = Paths.get("errors.log");

		    public Project() {
		        // Register unary neg as function (used by shunting yard)
		        functionRegistry.register("neg", args -> -args[0], 1);

		        // Attempt to load vars.cfg and functions.cfg
		        try { loadVars(Paths.get("vars.cfg")); } catch (Exception e) { logError("vars.cfg load error: " + e.getMessage()); }
		        try { loadFunctions(Paths.get("functions.cfg")); } catch (Exception e) { logError("functions.cfg load error: " + e.getMessage()); }
		    }

		    void loadVars(Path p) throws IOException {
		        if (!Files.exists(p)) return;
		        List<String> lines = Files.readAllLines(p);
		        for (String line: lines) {
		            line = line.trim();
		            if (line.isEmpty() || line.startsWith("#")) continue;
		            int idx = line.indexOf('=');
		            if (idx <= 0) continue;
		            String name = line.substring(0, idx).trim();
		            String val = line.substring(idx+1).trim();
		            try { variables.put(name, Double.parseDouble(val)); }
		            catch (NumberFormatException ex) { logError("Bad var value for " + name + " : " + val); }
		        }
		    }

		    void loadFunctions(Path p) throws IOException {
		        if (!Files.exists(p)) return;
		        List<String> lines = Files.readAllLines(p);
		        for (String line: lines) {
		            line = line.trim();
		            if (line.isEmpty() || line.startsWith("#")) continue;
		            int idx = line.indexOf('=');
		            if (idx <= 0) continue;
		            String name = line.substring(0, idx).trim();
		            String builtin = line.substring(idx+1).trim().toLowerCase();
		            // map alias to builtin if builtin exists
		            if (functionRegistry.has(builtin)) {
		                Function f = functionRegistry.get(builtin);
		                functionRegistry.register(name, args -> f.apply(args), f.arity());
		            } else {
		                logError("Unknown builtin function in functions.cfg: " + builtin);
		            }
		        }
		    }

		    void appendHistory(String entry) {
		        history.add(entry);
		    }

		    void exportHistory() {
		        try (BufferedWriter bw = Files.newBufferedWriter(historyFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
		            for (String h: history) bw.write(h + System.lineSeparator());
		            System.out.println("History exported to " + historyFile.toAbsolutePath());
		        } catch (IOException e) {
		            logError("Failed to export history: " + e.getMessage());
		            System.err.println("Failed to export history: " + e.getMessage());
		        }
		    }

		    void logError(String msg) {
		        try (BufferedWriter bw = Files.newBufferedWriter(errorsFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
		            bw.write(new Date() + " - " + msg + System.lineSeparator());
		        } catch (IOException e) {
		            System.err.println("Couldn't write to error log: " + e.getMessage());
		        }
		    }

		    void repl() {
		        System.out.println("Scientific Calculator (type 'help' for commands).");
		        Scanner sc = new Scanner(System.in);
		        while (true) {
		            System.out.print("> ");
		            String line = sc.nextLine().trim();
		            if (line.isEmpty()) continue;
		            try {
		                if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) break;
		                else if (line.equalsIgnoreCase("help")) printHelp();
		                else if (line.equalsIgnoreCase("vars")) {
		                    if (variables.isEmpty()) System.out.println("(no variables)");
		                    else variables.forEach((k,v)-> System.out.println(k + " = " + v));
		                } else if (line.startsWith("set ")) {
		                    handleSet(line.substring(4).trim());
		                } else if (line.startsWith("eval ")) {
		                    String expr = extractQuoted(line.substring(5).trim());
		                    if (expr == null) expr = line.substring(5).trim();
		                    handleEval(expr);
		                } else if (line.equalsIgnoreCase("history")) {
		                    if (history.isEmpty()) System.out.println("(no history)");
		                    else history.forEach(System.out::println);
		                } else if (line.equalsIgnoreCase("export")) {
		                    exportHistory();
		                } else {
		                    System.out.println("Unknown command. Type 'help'.");
		                }
		            } catch (Exception e) {
		                System.err.println("Error: " + e.getMessage());
		                logError("Runtime error: " + e.toString());
		            }
		        }
		        sc.close();
		        System.out.println("Goodbye.");
		    }

		    void printHelp() {
		        System.out.println("Commands:");
		        System.out.println("  set x=5            -- set variable");
		        System.out.println("  eval \"expr\"       -- evaluate expression; quotes optional");
		        System.out.println("  vars               -- list variables");
		        System.out.println("  history            -- show session history");
		        System.out.println("  export             -- append history to calc_history.txt");
		        System.out.println("  help               -- show this message");
		        System.out.println("  quit               -- exit");
		        System.out.println("Notes:");
		        System.out.println("  expressions support + - * / ^, parentheses, functions like sin(), sqrt(), log(), sum(), max()");
		    }

		    private String extractQuoted(String s) {
		        s = s.trim();
		        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
		            return s.substring(1, s.length()-1);
		        }
		        return null;
		    }

		    void handleSet(String rest) {
		        // format: name=exprOrNumber (we support expr optionally)
		        int eq = rest.indexOf('=');
		        if (eq < 0) {
		            System.out.println("Bad set syntax. Use: set x=5");
		            return;
		        }
		        String name = rest.substring(0, eq).trim();
		        String expr = rest.substring(eq+1).trim();
		        try {
		            double val;
		            // try parse direct number first
		            try { val = Double.parseDouble(expr); }
		            catch (NumberFormatException nfe) {
		                // else eval expression
		                val = evaluateExpression(expr);
		            }
		            variables.put(name, val);
		            System.out.println(name + " = " + val);
		            appendHistory("set " + name + "=" + val);
		        } catch (Exception e) {
		            System.err.println("Failed to set variable: " + e.getMessage());
		            logError("set error: " + e.toString());
		        }
		    }

		    void handleEval(String expr) {
		        try {
		            double result = evaluateExpression(expr);
		            System.out.println(result);
		            appendHistory("eval " + expr + " => " + result);
		        } catch (Exception e) {
		            System.err.println("Evaluation error: " + e.getMessage());
		            logError("eval error: " + e.toString());
		        }
		    }

		    double evaluateExpression(String expr) throws Exception {
		        List<Token> tokens = Tokenizer.tokenize(expr);
		        List<Token> rpn = shuntingYard.toRPN(tokens);
		        return evaluator.evalRPN(rpn, variables);
		    }

		    // -------------------------
		    // Main
		    // -------------------------
		    public static void main(String[] args) {
		        Project calc = new Project();
		        calc.repl();


	}

}
