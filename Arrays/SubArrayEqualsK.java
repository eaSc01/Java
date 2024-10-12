import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsK {
    public int subarraySumOptimal(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> preSum = new HashMap<>(); // contains sum vs frequency

        preSum.put(sum, 1); // for the case for where sum == k, so that sum - k should be found in hashmap,
                            // here if sum == k, sum - k would return 0, so the case 0 will be found in
                            // hashmap

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) { // we want the subarray to be of sum k, to find a subarray of sum k,
                                               // subtract current 'sum' from k and check if it occurred in hashmap
                                               // before, if it is, then this is new subarray that equals to sum k
                count += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1); // store the sum vs its frequency in the map,
        }
        return count;
    }

}
