import java.util.*;

public class input {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        //read number 1
        System.out.print("ENTER A NUMBER: ");
        int num1 = scan.nextInt();

        //read number 2
        System.out.print("ENTER ANOTHER NUMBER: ");
        int num2 = scan.nextInt();

        int sum = num1 + num2;
        System.out.print("SUM OF BOTH NUMBERS ARE ");
        System.out.print(sum);

        scan.close();
    }
}
