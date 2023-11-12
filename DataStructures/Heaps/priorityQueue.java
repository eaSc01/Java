import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueue {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student(45, "X"));
        pq.add(new Student(40, "A"));
        pq.add(new Student(20, "Y"));
        pq.add(new Student(90, "B"));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " " + pq.peek().rank);
            pq.remove();
        }
    }
}

