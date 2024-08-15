import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Banking System!");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                System.out.println("Enter 4-digit PIN:");
                String pin = scanner.nextLine();

                if (bank.registerUser(username, password, pin)) {
                    System.out.println("User registered successfully!");
                } else {
                    System.out.println("Username already exists.");
                }

            } else if (choice == 2) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                User user = bank.authenticateUser(username, password);
                if (user != null) {
                    System.out.println("Login successful!");
                    while (true) {
                        System.out.println("1. View Balance");
                        System.out.println("2. Transfer Funds");
                        System.out.println("3. Apply for Loan");
                        System.out.println("4. Logout");

                        int userChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        if (userChoice == 1) {
                            System.out.println("Enter account number:");
                            String accountNumber = scanner.nextLine();
                            Account account = user.getAccount(accountNumber);
                            if (account != null) {
                                System.out.println("Balance: " + account.getBalance());
                            } else {
                                System.out.println("Account not found.");
                            }

                        } else if (userChoice == 2) {
                            System.out.println("Enter from account number:");
                            String fromAccountNumber = scanner.nextLine();
                            System.out.println("Enter to account number:");
                            String toAccountNumber = scanner.nextLine();
                            System.out.println("Enter amount:");
                            double amount = scanner.nextDouble();

                            Account fromAccount = user.getAccount(fromAccountNumber);
                            Account toAccount = user.getAccount(toAccountNumber);
                            if (fromAccount != null && toAccount != null) {
                                if (fromAccount.transfer(toAccount, amount)) {
                                    System.out.println("Transfer successful!");
                                } else {
                                    System.out.println("Insufficient funds.");
                                }
                            } else {
                                System.out.println("Account(s) not found.");
                            }

                        } else if (userChoice == 3) {
                            System.out.println("Enter loan amount:");
                            double amount = scanner.nextDouble();
                            System.out.println("Enter interest rate:");
                            double interestRate = scanner.nextDouble();
                            System.out.println("Enter term (in months):");
                            int term = scanner.nextInt();

                            Loan loan = bank.applyForLoan(user, "L" + System.currentTimeMillis(), amount, interestRate, term);
                            System.out.println("Loan applied successfully! Monthly Payment: " + loan.calculateMonthlyPayment());

                        } else if (userChoice == 4) {
                            System.out.println("Logging out...");
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }

        scanner.close();
    }
}
