import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCheckTest {

    @Test
    public void test1() {
        int[] arr = {6,8,7,13,9,4};
        int n = 5;
      //  PrimeCheck.checkIsItANaturalNumber(n);

      // System.out.println(PrimeCheck.sequentialExecution(arr));
    }

    @Test
    public void test2() {
        int[] arr = {6,8,7,13,9,4};
        int n = 5;
        //  PrimeCheck.checkIsItANaturalNumber(n);

      // System.out.println(PrimeCheck.parallelExecutionTh(arr,4));
    }
}