package Arrays;

public class StaircaseSearchMatrix {

    public static void staircaseSearch(int matrix[][], int key) {

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col <= matrix[0].length - 1) {   //taking left bottom as initial

            if (key == matrix[row][col]) {
                System.out.println("ELEMENT FOUND AT (" + row + ", " + col + ")");
                return;

            } else if (key > matrix[row][col]) {
                col++;                        //to the right
            } else {
                row--;                        //to the top
            }
        } System.out.println("ELEMENT NOT FOUND");
    }
    
    public static void main(String args[]) {
        int array[][] = {{10,20,30,40}, 
                         {15,25,35,45},
                         {27,29,37,48},
                         {32,33,39,50}};

        staircaseSearch(array, 30);
    }
}
