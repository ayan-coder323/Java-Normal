package Home_Assignments;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter an email adrress :");

		        String email=sc.nextLine() ;

		        // REGEX for basic email validation
		        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(email);

		        if (matcher.matches()) {
		            System.out.println(email + " is a VALID email.");
		        } else {
		            System.out.println(email + " is NOT a VALID email.");
		        }
		    }
		}

