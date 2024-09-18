package Stacks;
class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode() {}

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}

public class StackLL<T> implements Stack<T> {
    
    private ListNode<T> top;
    public int size;

    public StackLL() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
    
        return top.val;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public void push(T e) {
        ListNode<T> newNode = new ListNode<>(e, top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }

        T e = peek();
        top = top.next;
        size--;
        return e;
    }

    @Override
    public int size() {
        return this.size;
    }


}
