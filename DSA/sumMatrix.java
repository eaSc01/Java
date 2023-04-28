public class sumMatrix { 

    public static void sumOf(int matrix[][]) {
        int sumRow = 0;
        int sumCol = 0;
        int totalSum = 0;
    
        for (int row = 0 ; row < matrix.length ; row++) {
            sumCol = 0;
            sumRow = 0;
            for (int col = 0 ; col < matrix[0].length ; col++) {
                totalSum += matrix[row][col];
                sumCol += matrix[col][row];
                sumRow += matrix[row][col];
            }
            System.out.println("SUM OF ROW " + row + " : " + sumRow + "\nSUM OF COL " + row + " : " + sumCol + "\n" );
        }
        System.out.println("SUM OF ALL: " + totalSum);
    }
    
    public static void main(String args[]) {
        int array[][] = {{1,2,3},{4,5,6}, {7,8,9}};
        sumOf(array);
    }
}