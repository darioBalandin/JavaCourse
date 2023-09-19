package org.dario;

public class Main {
    public static void main(String[] args) {


        BankAccount account = new BankAccount(BankAccount.AccountType.SAVINGS, 500);
        System.out.println(account);


        BankCustomer joe = new BankCustomer("Joe", 500.00, 1000.00);

        System.out.println(joe);

        var accounts= joe.getAccounts();
//        accounts.clear();
        System.out.println(joe);
    }
}