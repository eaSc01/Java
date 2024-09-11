import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Questions {

    static class StackingQueue {
        // Quxeue using 2 stacks, using add of O(n)

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isempty() {
            return s1.isEmpty();
        }

        public static void add(int data) { // O(n)
            while (!s1.isEmpty()) { // transfering all elements to another stack
                s2.push(s1.pop());
            }

            s1.push(data); // push data at bottom for FIFO manner

            while (!s2.isEmpty()) { // push back all elements to original stack
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (s1.isEmpty()) {
                return -1;
            }
            return s1.pop();
        }

        public static int view() {
            if (s1.isEmpty()) {
                return -1;
            }
            return s1.peek();
        }

    }

    static class QueingStacks {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void firstNonRepeatingChar(String str) {
        // all input are lowercase

        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // while loops break only cause of the 2 cases if,
            if (q.isEmpty()) {
                System.out.println("-1");
            } else { // when front of queue has the first non repeating character
                System.out.println(q.peek());
            }
        }
    }

    public static void alterChars(String str) { // using strings

        int start = 0;
        int mid = str.length() / 2;
        StringBuilder res = new StringBuilder("");

        while (start < str.length() / 2) {
            res.append(str.charAt(start++));
            res.append(str.charAt(mid++));
        }

        System.out.println(res);
    }

    public static void interLeave() {   //ez
        Queue<Integer> primary = new LinkedList<>();
        Queue<Integer> secondary = new LinkedList<>();
        
        // initialising primary queue
        for (int i = 1 ; i <= 6 ; i++) {
            primary.add(i);
        }
        int size = primary.size();

        // removing first half of primary and adding those into secondary
        for (int i = 0 ; i<size/2 ; i++ ) {
            secondary.add(primary.remove());
        }

        // interchanging  / interleave
        while (!secondary.isEmpty()) {
            primary.add(secondary.remove());
            primary.add(primary.remove());
        }

        
        // display primary queue
        while (!primary.isEmpty()) {
            System.out.println(primary.remove());
        }

    }

    public static void main(String[] args) {
        // firstNonRepeatingChar("aabccxb");
        // alterChars("1234567890");
        // interLeave();
    }
}
