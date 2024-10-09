package Arrays;

public class SubArraySum {

    public static int brute(int array[]) {

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

    public static int getMaxSumOptimal(int array[]) {

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        boolean allNegative = true ;
        
        for (int i=0 ; i<array.length ; i++) {
            currSum += array[i];
            if (currSum < 0) {
                currSum = 0;
            }

            if (array[i] > 0) {
                allNegative = false;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        if (allNegative == true) {              //will run only if all elements are negative, worst time comp: (O) n^3
            maxSum = Integer.MIN_VALUE;

            for (int start = 0 ; start<array.length ; start++) {
                for (int end = start ; end<array.length ; end++) {
                    currSum = 0;
                    for (int print = start ; print<=end ; print++) {
                        currSum += array[print];
                    }
                    maxSum = Math.max(currSum, maxSum);
                }
            } 
        } return maxSum;
    }

    public static int getMaxSumPrefixMethod(int array[]) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int prefix[] = new int[array.length];
        
        prefix[0] = array[0];
        for (int i = 1; i<array.length ; i++) {
            prefix[i] = prefix[i-1] + array[i];
        }

        for (int start = 0 ; start<array.length ; start++) {
            for (int end = start ; end<array.length ; end++) {
                curSum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];
            } 
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }


    public static void main(String args[]) {
        int arr[] = {4,2,6,7,1};
        int sum_= brute(arr);
        System.out.println("\n\nMAX SUM OF ALL: " + sum_);
    }
}