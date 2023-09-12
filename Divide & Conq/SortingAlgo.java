public class SortingAlgo {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void MergeSort(int arr[], int startInd, int endingInd) {
        // This approach is based on divide and conquer algorithm, where first we divide
        // the array using mid element into smaller parts until theres only one element
        // left, then we merge adjacent elements in sorted form. From sorting single and
        // small arrays, we continue it until the final array that is inputted for
        // sorting, hence this approach is also called as depth first approach

        // TC: O(nlogn)
        // SC: O(n)
        if (startInd >= endingInd) {
            return;
        }

        // Dividing
        int mid = (startInd + endingInd) / 2;
        MergeSort(arr, startInd, mid); // left array
        MergeSort(arr, mid + 1, endingInd); // right array
        MergeArr(arr, startInd, mid, endingInd); // merge the divided arrays

    }

    public static void MergeArr(int arr[], int startInd, int mid, int endingInd) {

        int AuxArray[] = new int[endingInd - startInd + 1];

        // iterators for each array
        int i = startInd;   // left part
        int j = mid + 1;    // right part
        int k = 0;  // aux array

        while (i <= mid && j <= endingInd) {
            if (arr[i] < arr[j]) {
                AuxArray[k++] = arr[i++];
            } else {
                AuxArray[k++] = arr[j++];
            }
        }

        // leftovers of left array
        while (i <= mid) {
            AuxArray[k++] = arr[i++];
        }

        // leftovers of right array
        while (j <= endingInd) {
            AuxArray[k++] = arr[j++];
        }

        // copying auxilliary array to original array
        for (k = 0, i = startInd; k < AuxArray.length; k++, i++) {
            arr[i] = AuxArray[k];
        }
    }

    public static void quickSort(int arr[], int startInd, int endingInd) {

        // this approach is also based on divide and conquer method, but using pivot &
        // partition

        // first step is to declaring a pivot element (can be random element, first or
        // last element, or median element), then we sort the array in partitions, at
        // first the the elements smaller than pivot will be swapped, then the pivot
        // element itself will be swapped with element where pivot element should be if
        // sorted.

        // then the array partition smaller than the pivot will be sorted in same manner
        // but with its own pivot element (i,e, index of pivot - 1), also the array
        // partion greater the pivot (i.e, index of pivot + 1), i.e, left and right
        // partition in a recursive manner until there's only single element left.

        // quicksort on the basis of pivot element at ending index.
        // TC: O(nlogn) as average, but worst case is O(n^2) when the pivot element is
        // greatest if already sorted as ascending order, and smallest element if pivot
        // element is already sorted as descending order (only if taking the ending
        // index element as pivot element, forms an arthemetic progression of
        // n+(n-1)+(n-1)+..+1, results in TC of O(n^2))
        // SC: O(1)
        if (startInd >= endingInd) {
            return;
        }

        int pivotIndex = quickSortPartition(arr, startInd, endingInd); // this index is the final position of pivot
                                                                       // element, not ending index
        quickSort(arr, startInd, pivotIndex - 1); // Left part of array
        quickSort(arr, pivotIndex + 1, endingInd); // right part of array
    }

    public static int quickSortPartition(int arr[], int startInd, int endingInd) {
        int pivotElement = arr[endingInd];
        int i = startInd - 1;

        for (int j = startInd; j < arr.length; j++) {
            if (arr[j] < pivotElement) {
                i++;

                // swap elements at i and j
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // after creating space for pivot element, swapping element at i with ending
        // index element, i.e, pivot element
        i++;
        int temp = pivotElement;
        arr[endingInd] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int advancedBinarySearch(int arr[], int target, int startInd, int endingInd) {

        // Must be rotated sorted array, hence, the sorted array must be rotated on some
        // pivot axis, and any elements shouldn't repeat either, take reference from
        // image.

        if (startInd > endingInd) { // if element is missing
            return -1;
        }

        int mid = (startInd + endingInd) / 2; // finds mid point of current array

        if (target == arr[mid]) { // if target = element at mid point
            return mid;
        }

        else if (arr[startInd] <= arr[mid]) {
            // Mid lies on Line 1

            if (arr[startInd] <= target && target <= arr[mid]) {
                // case a : left of mid
                return advancedBinarySearch(arr, target, startInd, mid - 1);

            } else {
                // case b : right of mid
                return advancedBinarySearch(arr, target, mid + 1, endingInd);
            }

        } else {
            // Mid lies on Line 2

            if (arr[mid] <= target && target <= arr[endingInd]) {
                // case c: right of mid
                return advancedBinarySearch(arr, target, mid + 1, endingInd);

            } else {
                // case d: left of mid
                return advancedBinarySearch(arr, target, startInd, mid - 1);
            }
        }

    }

    public static int modifiedBinarySearch(int arr[], int target, int startInd, int endingInd) {

        // non recursive, iterative

        // Must be rotated sorted array, hence, the sorted array must be rotated on some
        // pivot axis, and any elements shouldn't repeat either, take reference from
        // image.

        while (startInd <= endingInd) {
            int mid = (startInd + endingInd) / 2; // finds mid point of current array

            if (target == arr[mid]) { // if target = element at mid point
                return mid;
            }

            else if (arr[startInd] <= arr[mid]) {
                // Mid lies on Line 1

                if (arr[startInd] <= target && target <= arr[mid]) {
                    // case a : left of mid
                    endingInd = mid - 1;

                } else {
                    // case b : right of mid
                    startInd = mid + 1;
                }

            } else {
                // Mid lies on Line 2

                if (arr[mid] <= target && target <= arr[endingInd]) {
                    // case c: right of mid
                    startInd = mid + 1;

                } else {
                    // case d: left of mid
                    endingInd = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 13, 14, 15, 9, 10, 11, 12 };

        // MergeSort(array, 0, array.length -1);
        // quickSort(array, 0, array.length - 1);
        printArr(array);
        // System.out.println(advancedBinarySearch(array, 12, 0, array.length - 1));
        // System.out.println(modifiedBinarySearch(array, 12, 0, array.length - 1));
    }
}