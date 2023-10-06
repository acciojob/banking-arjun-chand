package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (!isValidLicenseId(tradeLicenseId)){
            char[] charArray = tradeLicenseId.toCharArray();
            for (int i = 1; i < charArray.length; i+=2){
                char temp = charArray[i - 1];
                charArray[i - 1] = charArray[i];
                charArray[i] = temp;
            }
            tradeLicenseId = new String(charArray);
            if(!isValidLicenseId(tradeLicenseId)){
                throw new Exception("Valid License can not be generated");
            }
        }


    }
    public boolean isValidLicenseId(String licenseId){
        for(int i = 1; i < licenseId.length(); i++){
            if(licenseId.charAt(i - 1) == licenseId.charAt(i))
                return false;
        }
        return true;
    }

}
