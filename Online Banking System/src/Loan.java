public class Loan {
    private String loanId;
    private double amount;
    private double interestRate;
    private int term; // in months
    private double balance;

    public Loan(String loanId, double amount, double interestRate, int term) {
        this.loanId = loanId;
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
        this.balance = amount;
    }

    public double calculateMonthlyPayment() {
        double monthlyRate = interestRate / 12 / 100;
        return amount * monthlyRate / (1 - Math.pow(1 + monthlyRate, -term));
    }

    public void makePayment(double payment) {
        balance -= payment;
    }

    public double getBalance() {
        return balance;
    }

    public String getLoanId() {
        return loanId;
    }
}
