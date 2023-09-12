public class queueImplement {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class DynamicQueue { // using LLs

        private Node front = null;   // head
        private Node rear = null;    // tail

        // empty
        public boolean isEmpty() {
            return rear == null && front == null;
        }

        // enqueue (add)
        public void add(int data) {

            Node newNode = new Node(data);
            // very first element
            if (front == null) {
                front = rear = newNode;
                return;
            } 

            rear.next = newNode;
            rear = newNode;
        }

        // dequeue (remove)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Underflow");
                return Integer.MIN_VALUE;
            }
            
            int frontVal = front.data;
            
            if (front == rear) {    // single element
                front = rear = null;
            } else {
                front = front.next;
            }

            return frontVal;
        }
        
        // peek (front val)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return Integer.MIN_VALUE;
            }
            return front.data;
        }
    }

    static class ArrayQueue {  // using circular arrays
        private int arr[];
        private int rear;
        private int front;
        private int size;

        ArrayQueue(int size) {
            this.arr = new int[size];
            this.size = size;
            this.rear = -1;
            this.front = -1;
        }

        // empty
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        private boolean isFull() {
            return (rear + 1) % size == front;
        }

        // enqueue (add)
        public void add(int data) {
            if (isFull()) {
                System.out.println("Overflow");
                return;
            }

            // very first element
            if (front == -1) {
                front = 0;
            } 

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // dequeue (remove)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Underflow");
                return Integer.MIN_VALUE;
            }
            
            int frontVal = arr[front];
            // only single element
            if (front == rear) {
                front = rear = -1;
                return frontVal;
            }
            
            front = (front + 1) % size;
            return frontVal;
        }
        
        // peek (front val)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return Integer.MIN_VALUE;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        DynamicQueue q = new DynamicQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        System.out.println();
        while(!q.isEmpty()) {
            System.out.println(q.peek());   
            q.remove();
        }

    }
}
