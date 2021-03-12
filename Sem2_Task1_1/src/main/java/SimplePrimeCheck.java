public class SimplePrimeCheck {

    //Our prime numbers "flag".
    static boolean hasPrime = false;

    public static void main(String[] args) throws Exception {
        final int[] array = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053};

        for (int i = 0; i < array.length; i++) {
            if (Validation.isPrime(array[i])) {
                hasPrime = true;
                break;
            }
        }

        System.out.println(!hasPrime);
    }


}


