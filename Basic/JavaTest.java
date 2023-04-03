package Basic;
import java.util.*;

public class JavaTest {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        // Statement 1
        System.out.print("CHAR 1: ");
        String name0 = scan.nextLine();
        // Statement 2
        System.out.print("CHAR 2: ");
        String name1 = scan.nextLine();
        // Statement 3
        System.out.print("CHAR 3: ");
        String name2 = scan.nextLine();

        System.out.print("CHAR 1 = ");
        System.out.println(name0);

        System.out.print("CHAR 2 = ");
        System.out.println(name1);

        System.out.print("CHAR 3 = ");
        System.out.println(name2);

        scan.close();
    }
}
