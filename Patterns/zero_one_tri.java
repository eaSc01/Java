import java.util.Scanner;

public class zero_one_tri {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER NUMBER OF LINES: ");
        int n = scan.nextInt();

        for (int i = 1 ; i<=n ; i++) {
            System.out.println();
            for (int j = 1 ; j<=i ; j++) {
                if ((i+j)%2==0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
        }
        scan.close();
    }
}
