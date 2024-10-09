package Arrays;

public class SpiralMatrix {

    public static void spiralMatrice(int matrix[][]) {
        int sROW = 0;
        int sCOL = 0;
        int eROW = matrix.length - 1;
        int eCOL = matrix[0].length - 1;
        
        while (sROW <= eROW && sCOL <= eCOL) {
            
            //top
            for (int j = sCOL ; j<=eCOL ; j++) {
                System.out.print(matrix[sROW][j] + " ");
            }

            //right
            for (int i = sROW + 1 ; i<=eROW ; i++) {
                System.out.print(matrix[i][eCOL] + " ");
            }

            //bottom
            for (int j = eCOL - 1 ; j>=sCOL ; j--) {
                if (sROW == eROW) {
                    break;
                }
                System.out.print(matrix[eROW][j] + " ");
            }

            //left
            for (int i = eROW - 1 ; i>=sROW + 1 ; i--) {
                if (eCOL == sCOL) {
                    break;
                }
                System.out.print(matrix[i][sCOL] + " ");
            }
            sROW++;
            sCOL++;
            eROW--;
            eCOL--;
        }
    }

    public static void main(String args[]) {
        int array[][] = {{1,2,3,4}, {5,6, 7,8}, {9, 10, 11,12}};
        spiralMatrice(array);
        System.out.println("\n");
    }

}
