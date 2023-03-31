import java.util.*;

public class binary_decimal {
    
    public static int bin_decimal(int binary_number) {
        int decimal_number = 0;
        for (int power = 0; binary_number>0 ; power++) {
            int last_dig = binary_number%10;
            decimal_number = decimal_number + (last_dig * (int) Math.pow(2, power));
            binary_number/=10;
        }
        return decimal_number;
    }

    public static int dec_binary(int decimal_number) {
        int binary_number = 0;
        for (int power = 0; decimal_number>0 ; power++) {
            int last_dig = decimal_number%2;
            binary_number = binary_number + (last_dig * (int) Math.pow(10, power));
            decimal_number /= 2;
        }
        return binary_number;
    }

    public static void main(String args[]) {
        
        Scanner scan = new Scanner(System.in);

        int input_number, converted_number;
        System.out.print("INPUT: ");
        input_number = scan.nextInt();

        converted_number = dec_binary(input_number);
        System.out.println("OUTPUT: " + converted_number);

        scan.close();
    }
}
