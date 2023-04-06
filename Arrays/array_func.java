import java.util.*;

public class array_func {
    public static void input_array(int array[], int range, Scanner scanf) {
        for (int i = 0 ; i<range; i++ ) {
            System.out.print("ENTER A[" + i + "]: ");
            array[i] = scanf.nextInt();
        }
    }

    public static void output_array(int array[], int range) {
        for (int i=0 ; i<range ; i++) {
            System.out.println("A[" + i + "]: " + array[i]);
        }
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int choice, length;
        int numbers[] = new int[20];

        do {
            System.out.print("\n\nENTER 1 TO ENTER ARRAY\nENTER 2 TO DISPLAY ARRAY\nENTER 3 TO QUIT\n\nENTER COMMAND: ");
            choice = scan.nextInt();

            if (choice == 1) {
                System.out.print("\nENTER NUMBER OF ELEMENTS TO ADD IN ARRAY: ");
                length = scan.nextInt();

                input_array(numbers, length, scan);
            
            } else if (choice == 2) {
                System.out.print("\nENTER NUMBER OF ELEMENTS TO DISPLAY IN ARRAY: ");
                length = scan.nextInt();

                output_array(numbers, length);

            } else if (choice == 3) {
                break;

            } else {
                System.out.print("\nINVALID INPUT");

            }

        } while (true);

        scan.close();

    }
}
