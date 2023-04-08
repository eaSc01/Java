package Basic;
import java.util.*;

public class reversenumber {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int remainder;
        int reverse = 0;
        System.out.print("ENTER YOUR NUMBER TO REVERSE: ");
        int number = scan.nextInt();
        int copy_number = number;

        while ( number>0) {
            remainder = number % 10;
            reverse = reverse*10 + remainder;
            number/=10;
        }

        System.out.println("Reverse of " + copy_number + " is : " + reverse);
        scan.close();
    }
}