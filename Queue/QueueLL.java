package Queue;
class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}

public class QueueLL<T> implements Queue<T> {

    private ListNode<T> start;
    private ListNode<T> end;

    private int size;

    public QueueLL() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.start.val;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(T e) {
        ListNode<T> newNode = new ListNode<>(e);

        if (start == null && end == null) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = end.next;
        }
        size++;
    }

    @Override
    public T delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        T e = start.val;
        start = start.next;
        size--;

        if (size == 0) {
            start = null;
            end = null;
        }
        return e;
    }
}
