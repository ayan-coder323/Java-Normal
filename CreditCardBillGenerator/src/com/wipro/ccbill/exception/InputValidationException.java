package com.wipro.ccbill.exception;

public class InputValidationException extends Exception {
		
		public  InputValidationException()
		{
			
		}
		
		public InputValidationException(String err)
		{
			super(err);
		}
		
		public String toString()
		{
			return "Invalid Input Data";
		}
}
