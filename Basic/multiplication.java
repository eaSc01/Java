package Basic;
import java.util.*;

public class multiplication {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER THE NUMBER: ");
        int number = scan.nextInt();

        for (int i = 1; i<=10; i++) {
            System.out.println(number + " X " + i + " = " + number*i);
        }

        scan.close();
    }
}