import java.util.*;

public class hw1 {
    public static void main(String args[]) {
        // int $ = 10;
        // System.out.print($);

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER A: ");
        float a = scan.nextFloat();
        System.out.print("ENTER B: ");
        float b = scan.nextFloat();
        System.out.print("ENTER C: ");
        float c = scan.nextFloat();
        System.out.print("AVERAGE: ");
        System.out.print((a+b+c)/3);
        scan.close();
    }
}