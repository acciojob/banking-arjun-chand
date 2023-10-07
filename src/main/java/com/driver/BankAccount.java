package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        if(sum > 9*digits){
            throw new Exception("Account Number can not be generated");
        }

        int quotient = sum/9;
        int remainder = sum%9;

        StringBuilder accNo = new StringBuilder();
        while(quotient-->0){
            accNo.append("9");
        }
       if (remainder > 0){
           accNo.append(remainder);
       }
       int remainingdigits = digits - accNo.length();
       while(remainingdigits-->0){
           accNo.append("0");
       }
       return accNo.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((balance - amount) < minBalance) {
            throw new Exception("Insufficient Balance");
        }else {
            balance -= amount;
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getBalance() {
        return balance;
    }
}