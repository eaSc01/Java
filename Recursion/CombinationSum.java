import java.util.*;

class Solution {
    // leetcode 39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombinations(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public void generateCombinations(
            int i,
            int target,
            int[] candidates,
            List<Integer> comb,
            List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        if (i == candidates.length) {
            return;
        }

        if (candidates[i] <= target) {
            comb.add(candidates[i]);
            generateCombinations(i, target - candidates[i], candidates, comb, ans);
            comb.remove(comb.size() - 1);
        }
        
        generateCombinations(i + 1, target, candidates, comb, ans);
    }

    // leetcode 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations2(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public void generateCombinations2(
            int i,
            int target,
            int[] candidates,
            List<Integer> comb,
            List<List<Integer>> ans
    ) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            if (candidates[j] <= target) {
                comb.add(candidates[j]);
                generateCombinations2(j + 1, target - candidates[j], candidates, comb, ans);
                comb.remove(comb.size() - 1);

            } else {
                break;
            }
        }
    }
}