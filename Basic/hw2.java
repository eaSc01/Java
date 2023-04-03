package Basic;
import java.util.*;

public class hw2 {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER SIDE OF THE SQUARE: ");
        float a = scan.nextFloat();
        System.out.print("AREA OF THE SQUARE IS: ");
        System.out.print(a*a);
        scan.close();
    }
}