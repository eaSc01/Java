import java.util.*;

public class prime {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int number;
        int count = 0;

        System.out.print("ENTER YOUR NUMBER: ");
        number = scan.nextInt();

        if (number == 1) {
            System.out.println(number + " IS A PRIME NUMBER");
        } else {
            for (int i=1 ; i<=number; i++) {
                if (number%i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(number + " IS A PRIME NUMBER");
            } else {
                System.out.println(number + " IS NOT A PRIME NUMBER");
            }
        }
    
        scan.close();
    }
}