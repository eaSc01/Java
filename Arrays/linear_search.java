import java.util.Scanner;

public class linear_search {

    public static int linearSearch(int array[], int target) {
        for (int i = 0 ; i<array.length ; i++) {
            if (array[i] == target) {
                return i;
            } 
        } return -1;
    }

    public static void input_array(int array[], Scanner scanf) {
        System.out.print("\nENTER NUMBER OF ELEMENTS TO ADD IN ARRAY: ");
        int range = scanf.nextInt();

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
        int element;
        int res = -1;
        
        input_array(numbers, scan);
        System.out.print("ENTER ELEMENT TO FIND IN ARRAY: ");
        element = scan.nextInt();

      
        //output_array(numbers, 5);
        res = linearSearch(numbers, element);
        
        if (res == -1) {
            System.out.print("\nELEMENT NOT FOUND");
        } else {
            System.out.print("ELEMENT FOUND AT INDEX [" + res + "]");
        }

    }
}