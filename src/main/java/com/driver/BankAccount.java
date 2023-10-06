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
        if (digits <= 0) {
            throw new Exception("Account Number can not be generated");
        }

        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            int digit = i == digits - 1 ? sum : (int) (Math.random() * 10);
            accountNumber.append(digit);
            sum -= digit;
        }

        if (sum == 0) {
            return accountNumber.toString();
        } else {
            throw new Exception("Account Number can not be generated");
        }
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