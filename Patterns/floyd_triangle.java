import java.util.Scanner;

public class floyd_triangle {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER NUMBER OF LINES: ");
        int n = scan.nextInt();
        int count = 1;
        for (int i = 1 ; i<=n ; i++) {
            System.out.println();
            for (int j = 1 ; j<=i ; j++) {
                System.out.print(count + "\t");
                count++;
            }
        }
        scan.close();
    }
}
