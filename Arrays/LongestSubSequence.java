import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubSequence {
    public static int longestConsecutiveBetter(int[] nums) {
        int longest = 0;
        Arrays.sort(nums);

        int count = 0;
        int lastValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (lastValue == (nums[i] - 1)) {
                count++;
                lastValue = nums[i];

            } else if (lastValue != nums[i]) {
                count = 1;
                lastValue = nums[i];
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static int longestConsecutiveOptimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer a : set) {
            if (!set.contains(a - 1)) {
                int count = 1;
                int x = a;
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
