import java.util.Scanner;

public class InverseHalfPyramid {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER NUMBER OF LINES: ");
        int n = scan.nextInt();

        for (int i = 1 ; i<=n ; i++) {
            System.out.println();
            for (int j = 1 ; j<=(n+1)-i ; j++) {
                System.out.print(j);
            }
        }
        scan.close();
    }
}
