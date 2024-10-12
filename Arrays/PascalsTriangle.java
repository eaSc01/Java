import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int r = 6, c = 3;
        // System.out.println("Element at [" + r + "][" + c + "] is " + calcNCR(r-1,
        // c-1));
        // printNthRow(r);
        List<List<Integer>> pascalTri = printTillNthRow(r);
        for (List<Integer> a : pascalTri) {
            for (Integer b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static int calcNCR(int n, int r) {
        int res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static void printNthRow(int row) {
        System.out.println(1 + " ");

        int ans = 1;
        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / (i);
            System.out.println(ans + " ");
        }
    }

    public static List<Integer> getNthRow(int row) {
        List<Integer> rowElements = new ArrayList<>();

        int curr = 1;
        rowElements.add(curr);
        for (int col = 1; col < row; col++) {
            curr = curr * (row - col);
            curr = curr / (col);
            rowElements.add(curr);
        }

        return rowElements;
    }

    public static List<List<Integer>> printTillNthRow(int rows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= rows; row++) {
            ans.add(getNthRow(row));
        }

        return ans;
    }

}
