package Heaps;

import java.util.*;

public class WeakestSoldier {

    static class Row implements Comparable<Row> {
        int idx;
        int soldiers;

        public Row(int idx, int soldiers) {
            this.idx = idx;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Row r2) {
            return (this.idx * this.soldiers) - (r2.idx * r2.soldiers);
        }
    }

    public static int[] weakestSoldier(int[][] rows, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < rows.length; i++) {
            int soldiers = 0;

            for (int j = 0; j<rows[0].length; j++) {
                if (rows[i][j] == 1) {
                    soldiers++;
                }
            }

            int idx = i;
            pq.offer(new Row(idx, soldiers));
        }

        int[] weakest = new int[k];
        for (int i = 0; i<k; i++) {
            weakest[i] = pq.poll().idx;
        }
        return weakest;
    }

    public static void main(String[] args) {
        int[][] army = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int[] n = weakestSoldier(army, 2);
        for (int a: n) {
            System.out.println("A" + a);
        }
    }

}
