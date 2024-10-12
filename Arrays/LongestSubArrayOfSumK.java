public class LongestSubArrayOfSumK {
    public static int positiveOptimal(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < nums.length) {
            while (left <= right && sum > k) { // for left pointer only, run when sum is greater than k so left part
                                               // needs to be trimmed
                sum -= nums[left];
                left++;
            }

            if (sum == k) { // sum found, check if its longest
                maxLen = Math.max(maxLen, sum);
            }

            right++;   // proceed to extend right side
            if (right < nums.length) {  // for edge case when right is at ending index 
                sum += nums[right];
            }
        }

        return maxLen;
    }
}
