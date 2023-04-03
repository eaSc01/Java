package Basic;
import java.util.*;

public class product {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER NUMBER 1: ");
        int num1 = scan.nextInt();

        System.out.print("ENTER NUMBER 2: ");
        int num2 = scan.nextInt();

        int product = num1 * num2;

        System.out.print("PRODUCT OF NUMBERS IS ");
        System.out.print(product);
        
        scan.close();
    }
}
