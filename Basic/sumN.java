package Basic;
import java.util.*;

public class sumN {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int count = 1;
        System.out.print("ENTER N: ");
        int max = scan.nextInt();
        int sum = 0;

        while (count <= max) {
            sum = sum + count;
            count++;
        }

        System.out.println("Sum of First " + max + " Natural Numbers is: " + sum);

        scan.close();
    }
}