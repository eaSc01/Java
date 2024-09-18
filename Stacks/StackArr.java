package Stacks;
public class StackArr<T> implements Stack<T> {

    /**
     * Stack uses a traditional array internally, having a fixed size, can be of generic type T
     */
    private T[] array;

    /**
     * Max Capacity of the stack
     */
    public int capacity;

    /**
     * Number of current elements in stack
     */
    private int size;

    /**
     * Index pointer pointing to the top of the stack
     */
    private int top;

    @SuppressWarnings("unchecked")
    public StackArr(int size) {
        this.array = (T[]) new Object[size];
        this.capacity = size;
        this.top = -1;
        this.size = 0;
    }

    @Override
    public T peek() {
        return this.array[top];
    }

    @Override
    public void push(T e) {
        if (size == capacity) {
            throw new IllegalStateException("Stack overflow");
        }

        top++;
        size++;
        this.array[top] = e;
    }

    @Override
    public T pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack underflow");
        }

        T e = this.array[top];
        top--;
        size--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public int size() {
        return this.size;
    }

}