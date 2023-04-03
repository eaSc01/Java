package Basic;
import java.util.*;

public class OddorEven {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER A NUMBER TO CHECK: ");
        int a = scan.nextInt();

        if (a%2 == 0) {
            System.out.println(a + " IS AN EVEN NUMBER");
        } else {
            System.out.println(a + " IS AN ODD NUMBER");
        }
        scan.close();
    }
}