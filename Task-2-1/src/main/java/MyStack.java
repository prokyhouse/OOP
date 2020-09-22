
public class MyStack {

    private Object[] arr;
    private int size;
    private int position;

    /**
     * @param size stack capacity
     */
    public MyStack(int size) {
        this.position = 0;
        this.size = size;
        this.arr = new Object[size];
    }

    /**
     * @param o smth that needed to push into stack
     */
    public void push(Object o) {
        try {
        arr[position++] = o;
        } catch (java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Stack is full");
            return;
        }
    }

    public Object pop() {


        try {
            return arr[--position];
        } catch (java.lang.ArrayIndexOutOfBoundsException e){
        System.out.println("Stack is full");
        System.out.println("Stack is empty");
        return null;
    }
    }

    /**
     * display our stack
     */
    public void printStack() {
        for (int i = 0; i < position; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * @return number of pushed objects
     */
    public int count(){
        return position;
    }
}
