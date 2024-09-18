package Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class QueueReversal {

    public static Queue<Integer> solution(Queue<Integer> q) {
        Stack<Integer> stk = new Stack<>();
        
        while(!q.isEmpty()) {
            stk.push(q.poll());
        }

        while (!stk.empty()) {
            q.offer(stk.pop());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        q.offer(9);
        q.offer(10);

        q = solution(q);

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
