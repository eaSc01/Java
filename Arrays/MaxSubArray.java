public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = { -2,-1,-1 };

        // int sum = bruteForce(nums);
        // int sum = prefixSum(nums);
        int sum = kadanesAlgo(nums);
        System.out.println("Max SubArray Sum: " + sum);
    }

    private static int kadanesAlgo(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }

    private static int bruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int scopeSum = 0;
                for (int k = i; k <= j; k++) {
                    scopeSum += nums[k];
                }
                // System.out.println("Sum: " + scopeSum);
                max = Math.max(max, scopeSum);
            }
        }

        return max;
    }

    private static int prefixSum(int[] arr) {
        int maxSubArray = Integer.MIN_VALUE;
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subArrSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                // System.out.println("Arr from " + arr[i] + " to " + arr[j] + " is " +
                // subArrSum);
                maxSubArray = Math.max(subArrSum, maxSubArray);
            }
        }

        return maxSubArray;
    }
}
