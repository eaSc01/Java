package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class InterleavingQueues {

    public static Queue<Integer> solution(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i<size/2; i++) {
            q2.offer(q.poll());
        }

        for (int i = 0; i<size/2; i++) {
            q.offer(q2.poll());
            q.offer(q.poll());
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
