import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 6, 7 };
        int[] nums2 = { 3, 4, 8, 9, 10 };

        mergeSorted(nums1, nums2);
        printArray(nums1);
        printArray(nums2);
    }

    public static void mergeSorted(int[] nums1, int[] nums2) {
        int left = nums1.length - 1;
        int right = 0;

        while (left >= 0 && right < nums2.length) {
            if (nums1[left] > nums2[right]) {
                swap(nums1, nums2, left, right);
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    public static void swap(int[] arr1, int[] arr2, int left, int right) {
        int temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
    }

    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
}