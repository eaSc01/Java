import java.util.Scanner;

public class InvertedHalfPyramd {
    public static void inverted_pyramid(int row) {
        for (int i = 1 ; i<=row ; i++) {
            System.out.println();

            for (int j = 1 ; j<=(row)-i ; j++) {
                System.out.print(" ");
            }

            for (int k = 1 ; k<=i ; k++) {
                System.out.print("*");
            }
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("ENTER NUMBER OF LINES TO BE PRINTED: ");
        int lines = scan.nextInt();

        inverted_pyramid(lines);

        scan.close();
    }
}
