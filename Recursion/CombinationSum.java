import java.util.*;

class Solution {
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
}