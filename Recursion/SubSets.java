package Recursion;
import java.util.*;

public class SubSets {

    // subsets - i
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        calc(0, nums, ans, set);
        return ans;
    }

    void calc(int i, int[] nums, List<List<Integer>> ans, List<Integer> set) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(set));
            return;
        }

        calc(i + 1, nums, ans, set);

        set.add(nums[i]);
        calc(i + 1, nums, ans, set);

        set.remove(set.size() - 1);
    }

    // subsets - ii
    public List<List<Integer>> subsetsWithoutDuplicateList(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generateSet(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void generateSet(int i, int[] nums, List<Integer> set, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(set));

        for (int j = i; j < nums.length; j++) {
            if (j != i && nums[j] == nums[j - 1]) {
                continue;
            }
            set.add(nums[j]);
            generateSet(j + 1, nums, set, ans);
            set.remove(set.size() - 1);
        }
    }

}
