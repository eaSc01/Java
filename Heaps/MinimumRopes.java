package Heaps;

import java.util.*;

public class MinimumRopes {
    
    public static int minimumRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        for (int r: ropes) {
            pq.offer(r);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int c = first + second;
            cost += c;

            pq.add(c);
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};

        System.out.println(minimumRopes(arr));
    }

}
