public class SubArrSUM_BruteForce {

    public static int SubArr_Sum(int array[]) {

        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for (int start = 0 ; start<array.length ; start++) {
            System.out.println();

            for (int end = start ; end<array.length ; end++) {
                System.out.println();
                current_sum = 0;
                
                for (int print = start ; print<=end ; print++) {
                    System.out.print(array[print] + ",");
                    current_sum += array[print];
                } 
                System.out.print("\tSUM: " + current_sum);
                
                if (current_sum > max_sum) {
                    max_sum = current_sum;
                }
            }
        } 
        return max_sum;
    }
    public static void main(String args[]) {
        int arr[] = {4,2,6,7,1};
        int sum_= SubArr_Sum(arr);
        System.out.println("\n\nMAX SUM OF ALL: " + sum_);
    }
}