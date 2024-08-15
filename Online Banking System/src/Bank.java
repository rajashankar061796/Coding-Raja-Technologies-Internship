import java.util.HashMap;

public class Bank {
    private HashMap<String, User> users;

    public Bank() {
        users = new HashMap<>();
    }

    public boolean registerUser(String username, String password, String pin) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, pin));
        return true;
    }

    public User authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    public void createAccount(User user, String accountNumber, String accountType, double initialBalance) {
        Account account = new Account(accountNumber, accountType, initialBalance);
        user.addAccount(account);
    }

    public Loan applyForLoan(User user, String loanId, double amount, double interestRate, int term) {
        Loan loan = new Loan(loanId, amount, interestRate, term);
        // In a real system, you would add this loan to a list of loans for the user.
        return loan;
    }
}
