package Basic;
import java.util.*;

public class tax {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER ANNUAL INCOME IN LAKHS: ");
        float income = scan.nextFloat();
        float tax;

        if (income <= 500000) {
            tax = income*0;

        } else if (income>=500000 && income<=100000) {
            tax = (float) (income * 0.2);

        } else {
            tax = (float) (income * 0.3);
        }

        System.out.println("PAYABLE TAX: " + tax);
        scan.close();
    }
}