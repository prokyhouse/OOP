public class ThreadPrimeCheck {

    //Returns the number of processors available to the Java virtual machine. (can be optional)
    static final int THREADS = Runtime.getRuntime().availableProcessors();
    //Our prime numbers "flag".
    static boolean hasPrime = false;

    public static void main(String[] args) throws Exception {

        Thread[] t = new Thread[THREADS];
        PrimeRun.m = new Monitor();

        for (int i = 0; i < THREADS; i++) {
            t[i] = new Thread(new PrimeRun(i));
            t[i].start();
        }

        // to force one thread to wait for another thread to finish.
        for (int i = 0; i < THREADS; i++)
            t[i].join();

        System.out.println(hasPrime);
    }


    public synchronized static void primeChecker() {
        hasPrime = true;
    }

}

class PrimeRun implements Runnable {

    final int[] array = {4, 8, 16};
    public static Monitor m;
    final int ID;

    public PrimeRun(int i) {
        ID = i;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % ThreadPrimeCheck.THREADS == ID)
                if (Validation.isPrime(array[i]))
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