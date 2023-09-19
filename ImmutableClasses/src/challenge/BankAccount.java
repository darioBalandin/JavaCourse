package challenge;

public class BankAccount {


    public enum AccountType {CHECKING, SAVINGS}

    private final AccountType type;

    private double balance;

    public BankAccount(AccountType type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

}
