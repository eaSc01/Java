import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static Integer majorityElementN2(int[] nums) {
        int el = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                el = nums[i];
                count = 1;

            } else if (el == nums[i]) {
                count++;

            } else {
                count--;
            }
        }

        int freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                freq++;
            }
        }

        return freq > (nums.length / 2) ? el : -1;
    }

    public static List<Integer> majorityElementN3Brute(int[] nums) {
        int target = nums.length / 3;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (ans.isEmpty() || !ans.contains(nums[i])) {
                int count = 0;

                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }

                if (count > target) {
                    ans.add(nums[i]);
                }
            }
        }

        return ans;
    }

    public List<Integer> majorityElementN3Hashed(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int newValue = map.get(nums[i]) + 1;
                map.put(nums[i], newValue);

            } else {
                map.put(nums[i], 1);
            }

            if (map.get(nums[i]) > nums.length / 3 && !ans.contains(nums[i])) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public static List<Integer> majorityElementN3Optimial(int[] nums) {
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i<nums.length; i++) {
            if (c1 == 0 && el2 != nums[i]) {
                el1 = nums[i];
                c1 = 1;

            } else if (c2 == 0 && el1 != nums[i]) {
                el2 = nums[i];
                c2 = 1;

            } else if (el1 == nums[i]) {
                c1++;

            } else if (el2 == nums[i]) {
                c2++;

            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == el1) {
                c1++;
            }
            if (nums[i] == el2) {
                c2++;
            }
        }

        if (c1 > nums.length/3) {
            ans.add(el1);
        }

        if (c2 > nums.length/3) {
            ans.add(el2);
        }

        return ans;
    }
}
