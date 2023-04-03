package Basic;
import java.util.*;

public class hw3 {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER PRICE OF A: ");
        float a = scan.nextFloat();

        System.out.print("ENTER PRICE OF B: ");
        float b = scan.nextFloat();

        System.out.print("ENTER PRICE OF C: ");
        float c = scan.nextFloat();

        System.out.print("TOTAL COST: ");
        System.out.print((a+b+c)+(18/(a+b+c)));

        scan.close();
    }
}