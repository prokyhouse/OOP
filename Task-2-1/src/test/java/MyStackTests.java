import org.junit.Assert;
import org.junit.Test;

public class MyStackTests {

    @Test
    public void test1() {

        MyStack st = new MyStack(5);
        st.push(2);
        st.push(7);
        st.pop();
        Assert.assertEquals(1, st.count());
    }

    @Test
    public void test2() {
        MyStack st = new MyStack(0);
        st.push(2);
        st.push(7);
        Assert.assertEquals(0, st.count());
    }

    @Test
    public void test3() {

        MyStack st = new MyStack(2);
        st.push(2);
        st.push(7);
        st.push(2);
        st.push(7);
        st.push(2);
        st.push(7);
        st.push(2);
        st.push(7);
        Assert.assertEquals(2, st.count());
    }
}