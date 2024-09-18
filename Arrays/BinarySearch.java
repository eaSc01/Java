import java.util.*;

public class BinarySearch {
    public static int BinarySearch(int array[], int key) {
        
        int start = 0;
        int end = array.length - 1;

        while (start<=end) {
            int mid = (start + end)/2;
            
            if (array[mid] == key) {        //element found
                return mid;
            } else if (array[mid] > key) {  //left
                end = mid - 1;
            } else {                        //right
                start = mid + 1;
            }
        } return -1;
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
        int numbers[] = new int[10];

        input_array(numbers, 10, scan);

        System.out.print("ENTER KEY: ");
        int element = scan.nextInt();

        int loc = BinarySearch(numbers, element);

        if (loc == -1) {
            System.out.print("ELEMENT NOT FOUND\n");
        } else {
            System.out.print("ELEMENT FOUND AT LOCATION " + loc);
        }

        scan.close();
    }
}
