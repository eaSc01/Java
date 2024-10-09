package Backtracking;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, n, board(n), ans);
        return ans;
    }

    private void solve(
        int col, 
        int n,
        List<char[]> board,
        List<List<String>> ans
    ) {
        if (col == n) {
            List<String> valid = new ArrayList<>();
            for (char[] r: board) {
                valid.add(new String(r));
            }
            ans.add(valid);
            return;
        }

        for (int i = 0; i<n; i++) {
            if (isSafe(i, col, board)) {
                board.get(i)[col] = 'Q';
                solve(col + 1, n, board, ans);
                board.get(i)[col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, List<char[]> board) {
        // upper left diagonal
        for (int i = row - 1, j = col - 1; i>=0 && j>=0 ; i--, j--) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        // left side
        for (int i = col - 1; i>=0; i--) {
            if (board.get(row)[i] == 'Q') {
                return false;
            }
        }

        // lower left diagonal
        for (int i = row + 1, j = col - 1; i < board.size() && j>=0 ; i++, j--) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<char[]> board(int n) {
        List<char[]> board = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            char[] row = new char[n];

            for (int j = 0; j<n; j++) {
                row[j] = '.';
            }

            board.add(row);
        }

        return board;
    }


}