
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Payable> paymentQueue = new ArrayList<>();

        Payable card = new CreditCard("Danny yo", 100.0, 200.0);
        Payable meal = new MealPlan("Iron man", 40.0);

        paymentQueue.add(card);
        paymentQueue.add(meal);

        for (Payable p : paymentQueue) {
            p.processPayment(50.0);
        }

        System.out.println("Total transactions processed: " + PaymentMethod.totalTransactions);
    }
}

