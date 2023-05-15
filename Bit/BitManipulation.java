import java.util.Scanner;

public class BitManipulation {


    //function displays the bit of specific position
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

    // this function clears or sets the reqired bit to 1 in a binary number
    public static int setIth(int number, Scanner scan) {

        //Binary OR with 1 on the specified pos sets the bit to 1
        System.out.print("ENTER POSITION: ");
        int position = scan.nextInt();
        int bitMask = 1<<position;

        number = number | bitMask;
        return number;
    }


    // this function clears or sets the reqired bit to 0 in a binary number
    public static int clearIth(int number, int position) {

        int bitMask = ~(1<<position);   
        
        // this time, the complement is effecting bitMask negatively,
        // the complement of (1<<i) returns the required bits which we can perform 
        // Binary AND operation against the required number to clear the bit

        return number & bitMask;
    }   


    //this functions sets or clears a specific bit of binary number
    public static int updateIth(int number, int pos, int newBit) {

        // first clearing the required position, then pushing the newBit to the required position in bitMask
        // and then operation binary AND on number and bitMask

        number = clearIth(number, pos);
        int bitMask = newBit<<pos;
        return number | bitMask;
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

    public static int clearLastI(int number, int pos) {
        int bitMask = (~0) << pos;  //shifting the complement of 0 i times to the left in bitMask
        return number & bitMask;    // returns binary AND operation on number and bitmask, clears last i numbers of the original number
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        // checkNum(454);
        // System.out.println(getIth(6, scan));
        // System.out.println(setIth(10, scan));
        // System.out.println(clearIth(10, 2));
        // System.out.println(updateIth(10, 2, 1));
        System.out.println(clearLastI(15, 2));
        scan.close();
    }
}