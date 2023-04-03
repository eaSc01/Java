package Basic;
import java.util.Scanner;

public class integers { 
    public static void main(String[]args){
        
            Scanner scan = new Scanner(System.in);

            int number, choice;
            int OddSum = 0;
            int EvenSum = 0;

            do {
                System.out.print("\nENTER YOUR NUMBER: ");
                number = scan.nextInt();

                if (number%2 == 0) {
                    EvenSum+=number;
                } else {
                    OddSum+=number;
                }

                System.out.print("\n\nENTER 1 TO ADD MORE INTEGERS\nENTER 2 TO DISPLAY SUM\nENTER YOUR COMMAND: ");
                choice = scan.nextInt();

            } while (choice==1);

            if (choice == 2) {
                System.out.println("\nSUM OF ODD INTEGERS: " + OddSum + "\nSUM OF EVEN INTEGERS: " + EvenSum);
            } else {
                System.out.println("WRONG INPUT");
            }

            scan.close();
        }
    }    
