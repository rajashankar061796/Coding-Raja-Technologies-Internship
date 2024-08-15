import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String pin;
    private HashMap<String, Account> accounts;

    public User(String username, String password, String pin) {
        this.username = username;
        this.password = password;
        this.pin = pin;
        this.accounts = new HashMap<>();
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }
}
