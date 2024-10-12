import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] nums = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] ans = mergeOptimised(nums);
        printMatrix(ans);
    }

    public static int[][] mergeOptimised(int[][] nums) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(nums, Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));

        // calculate in single interval

        ans.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] <= ans.get(ans.size() - 1)[1]) {
                // sub interval found
                ans.set(ans.size() - 1,
                        new int[] {
                                ans.get(ans.size() - 1)[0], Math.max(nums[i][1], ans.get(ans.size() - 1)[0])
                        });
            } else {
                // not found, add as a new interval
                ans.add(nums[i]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static int[][] merge(int[][] nums) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(nums, Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));

        // (2n)
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i][0];
            int end = nums[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                // alr covered in last interval inside ans[][]
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j][0] <= end) {
                    // belongs to selected interval
                    end = Math.max(end, nums[j][1]);
                } else {
                    // doesnt belong, break
                    break;
                }
            }

            ans.add(new int[] { start, end });
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
