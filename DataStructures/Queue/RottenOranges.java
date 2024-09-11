import java.util.Queue;
import java.util.LinkedList;

class Item {
    int x;
    int y;
    int time;

    public Item(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Item> q = new LinkedList<>();

        int freshOranges = initQueue(q, grid);

        if (freshOranges == 0) {
            return 0;
        }

        int time = 0;
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { -1, 1, 0, 0 };

        while (!q.isEmpty()) {
            Item orange = q.poll();
            time = Math.max(time, orange.time);

            for (int i = 0; i < 4; i++) {
                int nx = orange.x + dx[i];
                int ny = orange.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    freshOranges--;
                    q.offer(new Item(nx, ny, orange.time + 1));
                }
            }
        }

        if (freshOranges > 0) {
            return -1;
        }

        return time;
    }

    private int initQueue(Queue<Item> q, int[][] grid) {
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Item(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        return fresh;
    }
}