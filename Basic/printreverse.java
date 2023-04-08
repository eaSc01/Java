package Basic;
import java.util.*;

public class printreverse {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        int remainder, number;
        System.out.print("ENTER YOUR NUMBER: ");
        number = scan.nextInt();

        while ( number>0 ) {
            remainder = number%10;
            System.out.print(remainder);
            number/=10;
        }
        scan.close();     
    }
}