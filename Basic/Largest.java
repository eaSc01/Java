package Basic;
import java.util.*;

public class Largest {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER NUMBER 1: ");
        int a = scan.nextInt();
        System.out.print("ENTER NUMBER 2: ");
        int b = scan.nextInt();
        System.out.print("ENTER NUMBER 3: ");
        int c = scan.nextInt();

        if (a > b) {
            if (a > c) {
                System.out.println("LARGEST" + a);
            } else {
                System.out.println("LARGEST" + c);
            }
        } else if (a < b) {
            if (b > c) {
                System.out.println("LARGEST" + b);
            } else {
                System.out.println("LARGEST" + c);
            }
        } else if (a == b && b == c) {
            System.out.println("ALL ARE EQUAL");
        }
        scan.close();
    }
}
