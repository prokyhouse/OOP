import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;


public class HeapSortTest {

    @Test
    public void test1() {
        int input[] = new int[]{5, 4, 3, 2, 1};
        int answer[] = new int[]{1, 2, 3, 4, 5};
        HeapSort ob = new HeapSort();
        HeapSort.mySort(input);
        Assert.assertArrayEquals(answer, input);

    }

    @Test
    public void test2() {
        int input[] = new int[]{1000000000, 4, 3, 2, 1};
        int answer[] = new int[]{1, 2, 3, 4, 1000000000};
        HeapSort ob = new HeapSort();
        HeapSort.mySort(input);
        Assert.assertArrayEquals(answer, input);

    }

    @Test
    public void test3() {
        int input[] = new int[]{5, -1, 3, -30, 1};
        int answer[] = new int[]{-30, -1, 1, 3, 5};
        HeapSort ob = new HeapSort();
        HeapSort.mySort(input);
        Assert.assertArrayEquals(answer, input);
    }

    @Test
    public void test4() {
        int input[] = new int[]{5};
        int answer[] = new int[]{5};
        HeapSort ob = new HeapSort();
        ob.mySort(input);
        Assert.assertArrayEquals(answer, input);
    }

    @Test
    public void test5() {
        //int N = 100000000;
        int input[] = new int[]{100000000};
        int answer[] = new int[]{100000000};

        Random r = new Random();

        for (int i = 0; i < input.length; i++) {
            input[i] = r.nextInt();
            answer[i] = input[i];
        }
        HeapSort.mySort(input);
        Arrays.sort(answer);
        Assert.assertArrayEquals(answer, input);
    }
}
