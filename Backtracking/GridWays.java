package Backtracking;

public class GridWays {
    public static int gWaysBackTrack(int curRow, int curCol, int rows, int cols) {
        // reach destination cell (i.e row-1, col-1 cell) by using only right and down path.
        
        // base case
        if (curRow == rows - 1 && curCol == cols - 1) { // when reached on last, destination cell (gives 1 way)
            return 1;
        } 
        else if (curRow == rows || curCol == cols) {  // when exceeded number of rows or cols (gives 0 ways)
            return 0;
        }
        
        int rightWays = gWaysBackTrack(curRow, curCol + 1, rows, cols);  // right
        int downWays = gWaysBackTrack(curRow + 1, curCol, rows, cols);  // down
        return downWays + rightWays;
    }

    public static double factorial(int number) {
        double fact = 1;
        for (int i = number ; i>0 ; i--) {
            fact = fact * i;
        }
        return fact;
    }

    public static double gWaysPermutation(int curRow, int curCol, int rows, int cols) {
        int n = (rows - 1 + cols - 1);
        int r = (rows - 1);
        int p = (cols - 1);

        return factorial(n) / (factorial(r) * factorial(p));

    }
    public static void main(String[] args) {
        int rows=3, cols = 3;

        System.out.println("Total Ways: " + (int) gWaysPermutation(0, 0, rows, cols));
        // System.out.println(factorial(6));
    }
}
