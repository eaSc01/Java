package Basic;
import java.util.*;

public class cont {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("ENTER YOUR NUMBER: ");
            number = scan.nextInt();

            if (number%10 == 0) {
                continue;
                
            } else {
                System.out.print(number + " ");
                scan.close();
            }

            System.out.println();
        } 
        
        
    }
}