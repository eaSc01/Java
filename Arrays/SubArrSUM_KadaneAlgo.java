public class SubArrSUM_KadaneAlgo {

    public static int getMaxSum(int array[]) {

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i=0 ; i<array.length ; i++) {
            currSum += array[i];
            if (currSum < 0) {
                currSum = 0;
            }

            maxSum = Math.max(maxSum, currSum);
            
            // if (currSum > maxSum) {
            //     maxSum = currSum;
            // }
        }
        return maxSum;
    }
    public static void main(String args[]) {
        int numbers[] = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println("MAX SUM: " + getMaxSum(numbers));
    }
}