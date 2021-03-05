public class SimplePrimeCheck {

    //Our prime numbers "flag".
    static boolean hasPrime = false;

    public static void main(String[] args) throws Exception {
        final int[] array = {4, 8, 16};

        for (int i = 0; i < array.length; i++) {
            if (Validation.isPrime(array[i])) {
                hasPrime = true;
                break;
            }
        }

        System.out.println(hasPrime);
    }


}


