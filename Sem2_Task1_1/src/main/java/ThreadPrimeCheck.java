import java.util.Arrays;

public class ThreadPrimeCheck {

    //Returns the number of processors available to the Java virtual machine. (can be optional)
    static int THREADS = Runtime.getRuntime().availableProcessors();
    //Our prime numbers "flag".
    static boolean hasNotPrime = false;
    public static long[] arr;

    public static boolean threadRun(long[] array, int numberOfThreads) throws Exception {

        THREADS = numberOfThreads;
        Thread[] t = new Thread[THREADS];
        PrimeRun.m = new Monitor();
        arr = Arrays.copyOf(array, array.length);

        for (int i = 0; i < THREADS; i++) {
            t[i] = new Thread(new PrimeRun(i));
            t[i].start();
        }

        // to force one thread to wait for another thread to finish.
        for (int i = 0; i < THREADS; i++)
            t[i].join();

        return hasNotPrime;
    }

    public static long[] getArray() {
        return arr;
    }


    public synchronized static void primeChecker() {
        hasNotPrime = true;
    }

}

class PrimeRun implements Runnable {

    final long[] array = ThreadPrimeCheck.getArray();
    public static Monitor m;
    final int ID;

    public PrimeRun(int i) {
        ID = i;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % ThreadPrimeCheck.THREADS == ID)
                if (Validation.isNotPrime(array[i]))
                    m.addPrime();
        }
    }
}

/**
 * Monitor would make sure that only one thread is executing the code in the critical section
 */
class Monitor {
    public synchronized void addPrime() {
        ThreadPrimeCheck.primeChecker();
    }
}