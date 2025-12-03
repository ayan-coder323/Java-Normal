package com.wipro.ccbill.entity;

import java.util.Date;

import com.wipro.ccbill.exception.InputValidationException;

public class CreditCardBill {

    private String creditCardNo;
    private String customerid;
    private Date billDate;
    private Transaction monthTransaction[];

    public CreditCardBill() { }

    public CreditCardBill(String creditCardNo, String customerid, Date billDate, Transaction[] monthTransaction) {
        this.creditCardNo = creditCardNo;
        this.customerid = customerid;
        this.billDate = billDate;
        this.monthTransaction = monthTransaction;
    }

    public double getTotalAmount(String transactionType) {
        double amount = 0.0;

        		
        if (!(transactionType.equals("DB") || transactionType.equals("CR"))) {
            return 0.0;
        }

        for (int i = 0; i < monthTransaction.length; i++) {
            if (monthTransaction[i].getTransactionType().equals(transactionType)) {
                amount += monthTransaction[i].getTransactionAmount();
            }
        }
        return amount;
    }

    public double calculateBillAmount() {
        try {
            if (validateData().equals("valid")) {

                if (monthTransaction != null && monthTransaction.length > 0) {

                    double amountSpend = getTotalAmount("DB");
                    double amountPaid = getTotalAmount("CR");
                    double outstanding = amountSpend - amountPaid;

                    double interest = (outstanding * (19.9 / 100)) / 12;

                    return outstanding + interest;
                } else {
                    return 0.0;
                }
            }
        } catch (InputValidationException e) {
            return 0.0;
        }
        return 0.0; 
    }

    public String validateData() throws InputValidationException {

        if (creditCardNo == null || creditCardNo.length() != 16 
            || customerid == null || customerid.length() < 6) {
            throw new InputValidationException();
        }

        return "valid";
    }
}
