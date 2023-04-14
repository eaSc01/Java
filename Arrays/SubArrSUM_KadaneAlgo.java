public class SubArrSUM_KadaneAlgo {

    public static int getMaxSum(int array[]) {

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
    public static void main(String args[]) {
        int numbers[] = {-2,-3,-4,-2,-2,-2,-5,2};
        System.out.println("\nMAX SUM: " + getMaxSum(numbers));
    }
}