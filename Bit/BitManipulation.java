import java.util.Scanner;

public class BitManipulation {

    public static int getIth(int number, Scanner scan) {
        System.out.print("ENTER POSITION: ");
        int position = scan.nextInt();

        int bitMask = 1<<position;

        if ((number & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void OddorEven(int number) {
        int bitMask = 1;

        // & with bitmask 1 returns Least Significant Bit
        if ((number & bitMask) == 0) {  
            System.out.println(number + " IS AN EVEN NUMBER");;
        } else if ((number & bitMask) == 1) {
            System.out.println(number + " IS AN ODD NUMBER");
        }
    }

    public static void main(String args[]) {
        // checkNum(454);
        Scanner scan = new Scanner(System.in);
        System.out.println(getIth(6, scan));
    }
}