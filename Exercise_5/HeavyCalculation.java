
class HeavyCalculation implements Runnable {

    private long result = 0;

    public void run() {
        for (long i = 1; i <= 1_000_000_000L; i++) {
            result += i;
        }
    }
    public long getResult() {
        return result;
    }
}
