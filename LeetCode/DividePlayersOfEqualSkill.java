package LeetCode;

import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int left = 0;
        int right = skill.length - 1;

        int sum = skill[left] + skill[right];
        long chemistry = 0;

        while (left < right) {
            if (skill[left] + skill[right] != sum) {
                return -1;
            }

            chemistry += (long) skill[left++] * skill[right--];
        }

        return chemistry;
    }
}