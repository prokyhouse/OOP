import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticTest {

    @Test
    public void addition() {
        double a = 5.45;
        double b = 4.65;
        double result = a + b;
        Assert.assertEquals(result, Arithmetic.addition(a, b), 0);
    }

    @Test
    public void subtraction() {
        double a = 5.45;
        double b = 4.65;
        double result = a - b;
        Assert.assertEquals(result, Arithmetic.subtraction(a, b), 0);
    }

    @Test
    public void multiplication() {
        double a = 5.45;
        double b = 4.65;
        double result = a * b;
        Assert.assertEquals(result, Arithmetic.multiplication(a, b), 0);
    }

    @Test
    public void division() {
        double a = 5.45;
        double b = 4.65;
        double result = a / b;
        Assert.assertEquals(result, Arithmetic.division(a, b), 0);
    }

    @Test
    public void pow() {
        Assert.assertEquals(4, Arithmetic.pow(2, 2), 0);
    }

    @Test
    public void factorial() {
        Assert.assertEquals(6, Arithmetic.factorial(3), 0);
    }

    @Test
    public void log() {
        Assert.assertEquals(Math.log(100), Arithmetic.log(100), 0);
    }

    @Test
    public void sin() {
        Assert.assertEquals(Math.sin(1), Arithmetic.sin(1), 0);
    }

    @Test
    public void cos() {
        Assert.assertEquals(Math.cos(1), Arithmetic.cos(1), 0.00000000001);
    }

    @Test
    public void calculatorTest() {
        String input = "sin + - 1 2 1";
        double result = Calculator.calculate(input);
        Assert.assertEquals(0, result, 0);
    }

    @Test
    public void calculatorTest2() {
        String input = "/ 5 2";
        double result = Calculator.calculate(input);
        Assert.assertEquals(2.5, result, 0);
    }

}