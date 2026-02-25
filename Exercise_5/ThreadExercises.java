
public class ThreadExercises {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new GreeterTask(), "Lehman-Thread-1");
        Thread t2 = new Thread(new GreeterTask(), "Lehman-Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Thread stateThread = new Thread(new SleepTask());

        System.out.println("After creation: " + stateThread.getState());

        stateThread.start();
        System.out.println("After start(): " + stateThread.getState());

        Thread.sleep(500);
        System.out.println("While sleeping: " + stateThread.getState());

        stateThread.join();
        System.out.println("After completion: " + stateThread.getState());

        BankAccount account = new BankAccount();

        Runnable withdrawTask = () -> account.withdraw(700);

        Thread husband = new Thread(withdrawTask, "Husband");
        Thread wife = new Thread(withdrawTask, "Wife");

        husband.start();
        wife.start();
        husband.join();
        wife.join();

        HeavyCalculation calc = new HeavyCalculation();
        Thread calcThread = new Thread(calc);

        calcThread.start();
        calcThread.join();

        System.out.println("Calculation Finished: " + calc.getResult());
    }
}
