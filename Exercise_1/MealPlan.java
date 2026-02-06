
public class MealPlan extends PaymentMethod {

    public MealPlan(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void validateAccount() {
        if (balance < 0) {
            System.out.println("Meal plan balance cannot be negative.");
        }
    }
    @Override
    public void processPayment(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient meal plan balance. Transaction Declined.");
        } else {
            balance -= amount;
            PaymentMethod.totalTransactions++;
            System.out.println("Meal plan payment of $" + amount + " processed.");
        }
    }
}

