package LeetCode;

import java.util.*;

public class RankTransformAnArray {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int i = 0; i<sorted.length; i++) {
            map.putIfAbsent(sorted[i], map.size() + 1);
        }

        for (int i = 0; i<arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}