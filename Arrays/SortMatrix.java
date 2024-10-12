import java.util.Arrays;
import java.util.Comparator;

public class SortMatrix {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 2, 4 }, { 1, 2 } };

        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparing(a -> a[1]));

        printMatrix(arr);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
