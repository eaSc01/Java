import java.util.Scanner;

public class butterfly_pattern {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = 2;

        for (int i = 1 ; i <= n ; i++) {
            System.out.println();
            for (int j = 1 ; j<=i ; j++) {
                System.out.print("*");
            }
            for (int k = 1 ; k<= 2*(n-i) ; k++) {
                System.out.print(" ");
            }
            for (int j = 1 ; j<=i ; j++) {
                System.out.print("*");
            }
        }

        for (int i = n ; i>=1 ; i--) {
            System.out.println();
            for (int j = 1 ; j<=i ; j++) {
                System.out.print("*");
            }
            for (int k = 1 ; k<= 2*(n-i) ; k++) {
                System.out.print(" ");
            }
            for (int j = 1 ; j<=i ; j++) {
                System.out.print("*");
            }
        }

        scan.close();
    }
}
