public class SubArray {

    public static int getLargest(int array[]) {
        int max = Integer.MIN_VALUE;

        for (int i=0 ; i<array.length ; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        } return max;
    }

    public static int getLeast(int array[]) {
        int min = Integer.MAX_VALUE;

        for (int i=0 ; i<array.length ; i++) {
            if (array[i] < min) {
                min = array[i];
            } 
        } return min;
    }

    public static void getSubArray(int array[]) {

        int sumOf[] = new int[15];
        int sum_counter = 0;

        for (int start = 0 ; start<array.length ; start++) {

            for (int end = start ; end<array.length ; end++) {
                System.out.println();
                int sum = 0;
                for (int target = start ; target<=end ; target++) {
                    sum = sum + array[target];
                    System.out.print(array[target] + ",");
                }

                sumOf[sum_counter++] = sum;
                System.out.print("\tSUM: " + sum);
            }

            System.out.println();
        }

        System.out.println("\n");
        System.out.println("LARGEST SUM: " + getLargest(sumOf));
        System.out.println("LEAST SUM: " + getLeast(sumOf));

    }
    public static void main(String args[]) {
        int numbers[] = {1,-2,4,6,-4};

        getSubArray(numbers);
    }
}