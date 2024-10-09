package Backtracking;
public class nQueensSafe {

    static int count = 0;

    public static boolean isSafe(char board[][], int row, int col) {

        // function checks if queen is safe to place.
        
        // vertically above
        for (int i = row - 1; i >= 0 ; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // for left upper diagonal
        for (int i = row - 1, j = col - 1 ; i>=0 && j>=0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }


        // for upper left diagonal
        for (int i = row - 1, j = col + 1 ; i>=0 && j<board.length ; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static boolean nQueens(char board[][], int row) {

        // return type is bool to check possibilities for q(n-1).
        // this function actually traverses through each row and col recursively and puts Queen on safe spots

        // base case
        if (row == board.length) {
            // board(board);
            count++;
            return true;
        }

        // recusive work, without isSafe function, this actually finds how many possibilities exists to place queen in such a way that each queen occupies each row, cuz number of queens = rows.
        for (int col = 0 ; col < board.length ; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if (nQueens(board, row+1)) {  // recursive call, to find solution for n - 1 queens 
                    return true;
                }
                board[row][col] = '.';  // backtracking
                // when solution is unknown for n-1 (Q) 
            }
        }

        return false;
    }

    public static void board(char board[][]) {

        // prints chess board
        System.out.println("*________________________________________*");
        for (int i=0 ; i<board.length ; i++) {
            for (int j = 0 ; j<board[0].length ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int n = 5;     // n = number of queens and rows
        char board[][] = new char[n][n];

        // initialization
        for (int i=0 ; i<n ; i++) {
            for (int j = 0 ; j<n ; j++) {
                board[i][j] = '.';
            }
        }

        if (nQueens(board, 0)) {
            board(board);
            System.out.println("Yes");
        } else {
            System.out.println("Nope");
        }
        // System.out.println("Total Possibilities: " + count);
    }
}