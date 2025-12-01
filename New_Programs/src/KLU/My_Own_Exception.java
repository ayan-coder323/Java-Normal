package KLU;

public class My_Own_Exception extends Exception {

    private static int id[]    = {101,102,103,104,105,106};
    private static String name[]  = {"Ayan","Jay","Baibhav","Heemang","Satyam","Kuldeep"};
    private static int marks[] = {100,90,30,108,95,96};

    public My_Own_Exception(String str) {
		// TODO Auto-generated constructor stub
    	super(str);
	}

    public static void main(String[] args) {

        My_Own_Exception mE =
                new My_Own_Exception("Your marks is either less than 35 or greater than 100");

        try {
            System.out.println("Id\tName\tMarks");

            for(int i = 0; i < 6; i++) {

                if(marks[i] < 35 || marks[i] > 100) {
                    throw mE;
                }

                System.out.println(id[i] + "\t" + name[i] + "\t" + marks[i]);
            }
        }
        catch(My_Own_Exception e) {
            e.printStackTrace();
        }
    }
}
