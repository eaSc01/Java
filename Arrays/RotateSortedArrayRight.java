public class RotateSortedArrayRight {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
                //  0  1  2  3  4  5  6
        rotate(a, 3);

        for (int x : a) {
            System.out.print(x + ",");
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length; // getting the remaining number of rotations if k > nums.length, else k remains
                             // same

        int[] temp = new int[k];
        for (int i = 0; i<temp.length; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        // shifting
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
