package Heaps;

import java.util.*;

public class NearbyCars {
    static class Car implements Comparable<Car> {
        int x;
        int y;
        int idx;
        int distance;

        public Car(int x, int y, int idx, int distance) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Car c2) {
            return this.distance - c2.distance;
        }
    }

    public static void main(String[] args) {
        int[][] cars = {{ 3, 3 }, { 5,-1 }, { -2, 4 },  };
        int k = 2;

        PriorityQueue<Car> pq = new PriorityQueue<>();
        int j = 0;
        for (int[] a : cars) {
            pq.add(new Car(a[0], a[1], j++, getDistance(a[0], a[1])));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }

    public static int getDistance(int x, int y) {
        return x * x + y * y;
    }
}
