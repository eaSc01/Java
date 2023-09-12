import java.util.*;

public class stacksDS {

    static class StackA {

        // stack using arraylists
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public void push(int data) {
            list.add(data);
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int topVal = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return topVal;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    static class StackB {

        private static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private static Node top = null;

        private boolean isEmpty() {
            return top == null;
        }

        // push operation
        public void push(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                top = newNode;
                return;
            }
            newNode.next = top;
            top = newNode;
        }

        // pop operation
        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int topVal = top.data;
            top = top.next;
            return topVal;
        }

        // peek operation
        public int peek() {
            if (isEmpty()) {
                return -1;
            }

            return top.data;
        }

        // question 1
        public void pushAtBottom(int data) {
            if (isEmpty()) {
                push(data);
                return;
            }

            int top = pop();
            pushAtBottom(data);
            push(top);
        }

        public void reverseStack() {
            if (isEmpty()) {
                return;
            }

            int top = pop();
            reverseStack();
            pushAtBottom(top);
        }

        public void print() {
            for (Node i = top; i != null; i = i.next) {
                System.out.println(i.data);
            }
        }
    }

    public static void stockSpan() {
        // find stocks span for each day
        
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length]; // (index arthemetic)
        StackB stk = new StackB(); // stores previous High index

        // step 1 : initializing day 1 span
        span[0] = 1;
        stk.push(0);

        // step 2 : looping through each day to find its span
        for (int day = 1; day < stocks.length; day++) {
            int currPrice = stocks[day];

            // step 2.1 : removing all the elements from stacks that are not greater or
            // equal to currPrice
            while (!stk.isEmpty() && currPrice > stocks[stk.peek()]) {
                stk.pop();
            }

            // step 3 : finding span
            if (stk.isEmpty()) {
                span[day] = day + 1;

            } else {
                int previousHigh = stk.peek();
                span[day] = day - previousHigh;
            }

            // step 4 : pushing current day price (idx) in stack
            stk.push(day);
        }

        // displaying stocks span
        for (int i = 0; i < span.length; i++) {
            System.out.println("Day " + i + ": " + span[i]);
        }
    }

    public static void main(String[] args) {
        stockSpan();
    }
}
