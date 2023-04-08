public class Sum_SubArray {

    public static int getMaxSum (int array[]) {
        int max = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int start = 0 ; start<array.length ; start++) {

            for (int end = start ; end<array.length ; end++) {

                current_sum = 0;
                for (int target = start ; target<=end ; target++) {
                    current_sum += array[target];
                    // System.out.print(array[target] + ",");
                }
                // System.out.println("\tSUM: " + current_sum);     //displays sum of each sub array

                if (current_sum > max) {
                    max = current_sum;
                }
            }
        }   return max;
    }

    public static void main(String args[]) {
        int numbers[] = {2,4,6,8,10};
        System.out.println("MAX SUM: " + getMaxSum(numbers));
    }
}