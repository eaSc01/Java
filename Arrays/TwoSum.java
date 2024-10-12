import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { i, map.get(complement) };

            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] { -1, -1 };
    }

}