public class MatrixSum { 

    public static void sumOf(int matrix[][]) {
        int sumRow = 0;
        int sumCol = 0;
        int totalSum = 0;
        int diagnol_sum = 0;
    
        for (int row = 0 ; row < matrix.length ; row++) {
            sumCol = 0;
            sumRow = 0;

            diagnol_sum += matrix[row][row];
            
            if (row != matrix.length - row - 1) {
                diagnol_sum += matrix[row][matrix.length - row - 1];            // i+j = n -1, then j = n - i - 1 (J = COL INDEX)
            }
            for (int col = 0 ; col < matrix[0].length ; col++) {
                totalSum += matrix[row][col];
                sumCol += matrix[col][row];
                sumRow += matrix[row][col];

                // if (row == col || (row + col == matrix.length - 1)) {       // i + j = n - 1 (secondary diagnal)
                //     diagnol_sum += matrix[row][col];                        //not optimised for diagnols
                // }
                
            }
            System.out.println("SUM OF ROW " + row + " : " + sumRow + "\nSUM OF COL " + row + " : " + sumCol + "\n" );
        }
        System.out.println("SUM OF ALL: " + totalSum + "\nDIAGNOL SUM: " + diagnol_sum);
    }
    

    public static void main(String args[]) {
        int array[][] = {{1,2,3,4},{5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        sumOf(array);
    }
}