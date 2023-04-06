import java.util.*;

public class largest_element {

    public static int largest(int array[]) {            //program for largest

        int largest = Integer.MIN_VALUE;
        for (int i=0 ; i<array.length ; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    public static int smallest(int array[]) {           //program for smallest

        int smallest = Integer.MAX_VALUE;
        for (int i=0 ; i<array.length ; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }


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

        int numbers[] = new int[20];
        int length;

        System.out.print("ENTER ARRAY LENGTH: ");
        length = scan.nextInt();

        input_array(numbers, length, scan);

        System.out.println("LARGEST VALUE IS " + largest(numbers));
    }
}
