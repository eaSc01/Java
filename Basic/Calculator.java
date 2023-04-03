package Basic;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER NUMBER 1: ");
        float number_1 = scan.nextFloat();
        System.out.print("ENTER NUMBER 2: ");
        float number_2 = scan.nextFloat();
        System.out.print("ENTER OPERATOR, +,-,/,* or %: ");
        char operator = scan.next().charAt(0);

        System.out.print("RESULT: ");
                        
        switch (operator) {
            case '+' : System.out.print(number_1 + number_2);
                        break;
            case '-' : System.out.print(number_1 - number_2);
                        break;
            case '*' : System.out.print(number_1 * number_2);
                        break;
            case '/' : System.out.print(number_1 / number_2);
                        break;
            case '%' : System.out.print(number_1 % number_2);
                        break;
            default : System.out.print("INVALID OPERATOR");
                       
        }
        scan.close();
        
    }
}
