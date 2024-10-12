public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = { 1,3,2 };
        nextPermutation(nums);
        for (int a : nums) {
            System.out.print(a);
        }
    }

    public static void nextPermutation(int[] nums) {
        int idx = -1;

        // find break point
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // no breakpoint
        if (idx == -1) {
            System.out.println("None");
            reverse(nums, 0, nums.length);
            return;
        }

        // find the smallest number greater than nums[idx]
        for (int i = nums.length - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx + 1, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        for (int i = start; i < end / 2; i++) {
            swap(nums, i, end - i - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
