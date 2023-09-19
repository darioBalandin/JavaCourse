package challenge;

import java.util.Arrays;

public class BankCustomer {

    private final String name;
    private final String id;
    private final BankAccount[] accounts;

    public BankCustomer(String name, String id, BankAccount[] accounts) {
        this.name = name;
        this.id = id;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public BankAccount[] getAccounts() {
        return Arrays.copyOf(accounts, accounts.length);
    }
}
