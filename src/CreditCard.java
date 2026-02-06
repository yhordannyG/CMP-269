
public class CreditCard extends PaymentMethod {

    private double creditLimit;

    public CreditCard(String accountHolder, double balance, double creditLimit) {
        super(accountHolder, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void validateAccount() {
        if (creditLimit < 0) {
            System.out.println("Invalid credit limit.");
        }
    }

    @Override
    public void processPayment(double amount) {
        if (amount > balance + creditLimit) {
            System.out.println("Transaction Declined.");
        } else {
            balance -= amount;
            PaymentMethod.totalTransactions++;
            System.out.println("Credit card payment of $" + amount + " processed.");
        }
    }
}

