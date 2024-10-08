package Heaps;

import java.util.*;

public class SlidingWindowMaximum {

    static class Pair implements Comparable<Pair> {
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.value - p2.value;
        }
    }

    public static int[] windowMaximum(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] maximum = new int[arr.length - k + 1];

        for (int i = 0; i < k; i++) {
            pq.offer(new Pair(i, arr[i]));
        }
        maximum[0] = pq.peek().value;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            pq.offer(new Pair(i, arr[i]));
            maximum[i - k + 1] = pq.peek().value;
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int[] max = windowMaximum(arr, 3);

        for (int a: max) {
            System.out.print(a + ", ");
        }
    }

}
