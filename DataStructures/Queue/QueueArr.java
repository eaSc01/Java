public class QueueArr<T> implements Queue<T> {
    
    private T[] arr;
    private int start;
    private int end;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArr(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.start = -1;
        this.end = -1;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public void insert(T e) {
        if (isFull()) {
            throw new IllegalStateException("Queue overflow");
        }
    
        if (isEmpty()) {
            start = 0;
        }

        end = (end + 1) % arr.length;
        arr[end] = e;
        size++;
    }

    @Override
    public T delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        
        T e = arr[start];
        start = (start + 1) % arr.length;
        size--;

        if (size == 0) {
            start = -1;
            end = -1;
        }

        return e;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        return arr[start];
    }

    public boolean isFull() {
        return size == arr.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
