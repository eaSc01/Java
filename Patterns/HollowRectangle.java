import java.util.*;

public class HollowRectangle {

    public static void printer(int total_rows, int total_cols) {
        for (int row = 1 ; row <= total_rows ; row++) {
            System.out.println();
            for (int col = 1 ; col <= total_cols ; col++) {
                if ( row == 1 || col == 1 || row == total_rows || col == total_cols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER NUMBER OF LINES TO BE PRINTED: ");
        int lines = scan.nextInt();

        System.out.print("ENTER STARS PER LINE TO BE PRINTED: ");
        int spline = scan.nextInt();

        printer(lines, spline);
        scan.close();
    }
}