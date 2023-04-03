package Basic;
import java.util.*;

public class Ternary {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER MARKS:");
        float a = scan.nextFloat();

        String Report = (a > 33) ? "PASS" : "FAIL";
        System.out.print(Report);

        scan.close();
    }

}
