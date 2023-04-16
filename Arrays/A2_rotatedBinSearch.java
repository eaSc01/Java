public class A2_rotatedBinSearch {

    public static int RotatedBinSearch(int array[], int target) {
        int start = 0, end = array.length - 1;

        while (start<=end) {
            
            int mid = (start + end) / 2;

            if (array[mid] == target) {
                return mid;

            } else if (array[start] <= array[mid]) {

                //left is sorted
                if (target < array[mid] && target >= array[start]) {    //element check
                    end = mid - 1;
                } else {
                    start = mid + 1;        //switch to another part (to the right)
                }
            }

            else if (array[mid] <= array[end]) {

                //right is sorted
                if (target > array[mid] && target <= array[end]) {      //element check
                    start = mid + 1;
                } else {
                    end = mid - 1;          //switch to another part (to the left)
                }
            }
        } return -1;
    } 

    public static void main(String args[]) {
        int nums[] = {4,  5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(RotatedBinSearch(nums, target));
    }
}