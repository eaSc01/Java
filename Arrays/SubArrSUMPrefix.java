package Arrays;

public class SubArrSUMPrefix {
    public static int getMaxSum(int array[]) {
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
        int numbers[] = {2,3,5,-1,4};
        System.out.println("MAX SUM: " + getMaxSum(numbers));
    }   
}
