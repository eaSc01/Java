import java.util.*;

class Solution {  // random sequencing method
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], ans);
        return ans;
    }

    public void generatePermutations(
        int[] nums,
        List<Integer> perm,
        boolean[] freq,
        List<List<Integer>> ans
    ) {
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i<freq.length; i++) {
            if (!freq[i]) {
                perm.add(nums[i]);
                freq[i] = true;
                generatePermutations(nums, perm, freq, ans);
                freq[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}

class Solution2 { // swap method
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatePermutations(0, nums, ans);
        return ans;
    }

    public void generatePermutations(
        int i,
        int[] nums,
        List<List<Integer>> ans
    ) {
        if (i == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int a: nums) {
                perm.add(a);
            }
            ans.add(perm);
            return;
        }

        for (int j = i; j<nums.length; j++) {
            swap(nums, i, j);
            generatePermutations(i + 1, nums, ans);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}