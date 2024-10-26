package Graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int firstColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }

        if (vis[sr][sc] || image[sr][sc] != firstColor) {
            return;
        }

        image[sr][sc] = color;
        vis[sr][sc] = true;

        // up
        helper(image, sr + 1, sc, color, vis, firstColor);

        // down
        helper(image, sr - 1, sc, color, vis, firstColor);

        // left
        helper(image, sr, sc - 1, color, vis, firstColor);

        // right
        helper(image, sr, sc + 1, color, vis, firstColor);
    }
}
