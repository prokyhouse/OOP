public class Arithmetic {

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static double log(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    public static double log(double logNumber) {
        return Math.log(logNumber);
    }

    public static double pow(double base, double exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }

    public static double sqrt(double d) {
        //Newton method
        double sqrt = Double.longBitsToDouble(((Double.doubleToLongBits(d) - (1L << 52)) >> 1) + (1L << 61));
        double better = (sqrt + d / sqrt) / 2.0;
        return (better + d / better) / 2.0;
    }

    public static double factorial(double n) {
        if (n <= 1) // base case
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static double sin(double n) {
        // the first element of the taylor series
        double sum = n;
        // add them up until a certain precision (eg. 10)
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0)
                sum += pow(n, 2 * i + 1) / factorial(2 * i + 1);
            else
                sum -= pow(n, 2 * i + 1) / factorial(2 * i + 1);
        }
        return sum;
    }

    public static double cos(double n) {
        return sqrt(1 - pow(sin(n), 2));
    }
}
