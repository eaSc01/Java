public class RotateMatrix {
    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotateMatrix(nums);
        printMatrix(nums);
    }

    public static void rotateMatrix(int[][] nums) {
        int n = nums.length;
        int[][] temp = new int[n][n];

        // rotate into a new matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = nums[i][j];
            }
        }

        // get values back into original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = temp[i][j];
            }
        }
    }

    public static void printMatrix(int[][] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}