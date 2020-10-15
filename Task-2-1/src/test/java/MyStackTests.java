import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStackTests {

    //Test with Integers
    @Test
    public void test1() {
        MyStack<Integer> stack;
        stack = new MyStack<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < 100; ++i) {
            if ((i * 5) % 4 == 0) {
                stack.push(i);
                arr.add(i);
            } else {
                if (arr.size() != 0) {
                    int elementArr = arr.remove(arr.size() - 1);
                    int elementStack = stack.pop();
                    Assert.assertEquals(elementArr, elementStack);
                }
            }
        }
        Assert.assertEquals(arr.size(), stack.count());
    }

    //Test with Floats
    @Test
    public void test2() {
        MyStack<Float> stack;
        stack = new MyStack<Float>();
        ArrayList<Float> arr = new ArrayList<Float>();

        for (int i = 0; i < 1000; ++i) {
            if ((i * 5) % 2 == 0) {
                float num = (float) Math.random();
                stack.push(num);
                arr.add(num);
            } else {
                if (arr.size() != 0) {
                    int size = arr.size() - 1;
                    float elementArr = arr.remove(size);
                    float elementStack = stack.pop();
                    Assert.assertEquals(elementArr, elementStack, 0.0001);
                }
            }
        }
        Assert.assertEquals(arr.size(), stack.count());
    }

    //Two tests for strings
    @Test
    public void test3() {
        MyStack<String> stack = new MyStack<String>();
        stack.push("PushedStringOne");
        stack.push("PushedStringTwo");
        stack.pop();
        stack.pop();
        try {
            stack.pop();
            Assert.fail("Expected NoSuchElementException");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Test
    public void test4() {
        MyStack<String> stack;
        stack = new MyStack<String>();
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 1; i < 500; ++i) {
            if (i % 2 != 0) {
                stack.push("Stay hungry");
                arr.add("Stay hungry");
            } else {
                stack.push("Stay foolish");
                arr.add("Stay foolish");
            }
        }
        Assert.assertEquals(arr.size(), stack.count());
    }

    //Test for my iterator
    @Test
    public void test5() {

        for (int i = 0; i < 300; ++i) {
            MyStack<Integer> stack = new MyStack<Integer>();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            stack.push(i);
            arr.add(i);
            Iterator<Integer> iter = stack.iterator();
            Iterator<Integer> iter2 = arr.iterator();
            while (iter.hasNext()) {
                Assert.assertEquals(iter.next(), iter2.next());
            }
        }
    }
}