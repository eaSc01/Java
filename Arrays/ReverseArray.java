public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int a : nums) {
            System.out.print(a + ", ");
        }

        System.out.println();
        reverseArray(nums);

        for (int a : nums) {
            System.out.print(a + ", ");
        }

    }

    public static void reverseArray(int nums[]) {

        int lowIdx = 0;
        int highIdx = nums.length - 1;

        while (lowIdx < highIdx) {
            nums[lowIdx] = nums[lowIdx] + nums[highIdx];
            nums[highIdx] = nums[lowIdx] - nums[highIdx];
            nums[lowIdx] = nums[lowIdx] - nums[highIdx];

            lowIdx++;
            highIdx--;
        }

    }

}