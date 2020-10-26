
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that implements the work of the stack.
 *
 * @param <T> type of the elements.
 */

public class MyStack<T> {

   // private StackElement<T> positionStackElement = null;
   // private StackElement<T> head = null;

    private static final int DEFAULT_CAPACITY = 10;
    private T[] stackArray;
   // private int position = 0;
    private int size = 0;
    private int capacity;


    public MyStack(){
        this.capacity = DEFAULT_CAPACITY;
        stackArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        stackArray = (T[]) new Object[capacity];
    }
    /**
     * Method that pushes the element to the stack.
     *
     * @param element element that we need to put in the stack.
     */
    public void push(T element) {
        if (this.size >= stackArray.length) {
            int newSize = size + (size >> 1);
            stackArray = Arrays.copyOf(stackArray, newSize);
        }
        stackArray[size++] = element;
    }

    /**
     * Method that gets element from the stack.
     *
     * @return element of the stack if it exists, otherwise throws exception.
     * @throws IndexOutOfBoundsException throws this exception if the stack is empty.
     */
    public T pop() throws IndexOutOfBoundsException {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T element = stackArray[--size];
            stackArray[size] = null;

            int reducedSize = size;
            if (size >= capacity && size < (reducedSize + (reducedSize << 1))) {
                System.arraycopy(stackArray, 0, stackArray, 0, size);
            }
            return element;
        }
    }

    /**
     * Implementation of the Iterator for the stack.
     *
     * @return next element of the stack.
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            public boolean hasNext() {
                return !(position == size);
            }

            public T next() throws NoSuchElementException {
                return stackArray[position++];
            }
        };
    }


    /**
     * Check if the stack is empty.
     *
     * @return 1 - if the stack is empty, otherwise returns 0.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method that gets amount of elements in the stack.
     *
     * @return amount of pushed elements in the stack.
     */
    public int count() {
        return size;
    }
}
