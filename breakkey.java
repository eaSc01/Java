import java.util.*;

public class breakkey {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("ENTER YOUR NUMBER: ");
            number = scan.nextInt();

            if (number%10 == 0) {
                break;
            } else {
                System.out.print(number + " ");
            }

            System.out.println();

        }
        scan.close();
    }
}