import java.util.*;

public class multi_prime {

    public static boolean prime_number(int check_number) {
    
        for (int factor = 2 ; factor<= Math.sqrt(check_number) ; factor++) {
            if (check_number%factor == 0) {
                return false;
            }
        }
        return true;
    }

    public static int primeInRange(int range_number) {
        int total = 0;
        boolean check;
        for (int c_prime = 2 ; c_prime<=range_number ; c_prime++) {
            check = prime_number(c_prime);
            if (check == true) {
                total++;
                System.out.print(c_prime + "\t");
            }
        }
        return total;
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        int number;
        System.out.print("ENTER RANGE FROM 1 TO: ");
        number = scan.nextInt();

        number = primeInRange(number);

        System.out.println("\nNUMBER OF PRIME NUMBERS IN RANGE: " + number);

        scan.close();
    }
}
