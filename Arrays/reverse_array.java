public class reverse_array {
    public static void output_array(int array[], int range) {
        for (int i=0 ; i<range ; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void reverse(int array[]) {
        for (int i = 0 ; i<array.length/2 ; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void main(String args[]) {
        int numbers[] = {2, 4, 6, 7, 8, 9};
     
        reverse(numbers);
        output_array(numbers, 6);
    }
}
