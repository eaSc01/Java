import java.util.*;

public class factorial {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

            double factorial = 1;
            int number;

            System.out.print("ENTER YOUR NUMBER: ");
            number = scan.nextInt();

            for (int i = number; i>0; i--) {
                factorial = factorial * i;
            }

            System.out.println("FACTORIAL OF " + number + " IS " + factorial);

        scan.close();
    }
}