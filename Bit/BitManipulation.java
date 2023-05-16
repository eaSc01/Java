import java.util.Scanner;

public class BitManipulation {


    //function displays the bit of specific position
    public static int getIth(int number, int position) {

        int bitMask = 1<<position;

        if ((number & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // this function clears or sets the reqired bit to 1 in a binary number
    public static int setIth(int number, int position) {

        //Binary OR with 1 on the specified pos sets the bit to 1
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

    public static int clearRange(int number, int i, int j) {

        int a = (~0) << (j+1);  //bitmask part 1 (pushing 1s to left), all 1s on the right of j pos
        int b = (1<<i) - 1; 
        // here (1<<i) pushes 1 bit to i-th position, and subtracting it from 1 gives all 1s on the right of i pos
        int bitMask = a | b;    // final bitMask binary OR on a & b

        return number & bitMask;
    }

    public static boolean exponentOf2 (int number) {

        // binary and of number & number-1 is always 0 if the number is exponent of 2
        if ((number & (number-1)) == 0) {
            return true;
        }
        return false;
    }

    public static int countSetBits (int number) {
        int count = 0;

        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }


    public static int fastExponent (int number, int power) {
        int ans = 1;

        while (power != 0) {
            if ((power & 1) != 0) {
                ans = ans * number;
            }
            number = number * number;
            power = power >> 1;
            
        } return ans;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        // checkNum(454);
        // System.out.println(getIth(6, 2));
        // System.out.println(setIth(10, 3));
        // System.out.println(clearIth(10, 2));
        // System.out.println(updateIth(10, 2, 1));
        // System.out.println(clearLastI(15, 2));
        // System.out.println(clearRange(10, 2, 4));
        // System.out.println(exponentOf2(64));
        // System.out.println(countSetBits(20));
        // System.out.println(fastExponent(5,4));

        scan.close();
    }
}