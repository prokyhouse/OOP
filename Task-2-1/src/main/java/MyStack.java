
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
     * @param o push smth to stack
     */
    public void push(Object o) {
        if (position >= size) {
            System.out.println("Stack is full");
            return;
        }
        arr[position++] = o;
    }

    public Object pop() {
        if (position == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[--position];
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
