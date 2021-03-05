public class Validation {

    /**
     * @param n is our number
     * @return true if it does not satisfy the conditions of a non-Prime number
     */
    public static boolean isPrime(int n) {
        if (n == 2 || n == 3 || n == 5) return true;
        if (n <= 1 || (n & 1) == 0) return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;

        return true;
    }

}
