public class Account {
    private String accountNumber;
    private String accountType;
    private double balance;

    public Account(String accountNumber, String accountType, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }
}
