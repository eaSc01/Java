package Sorting;

public class MergeSort {
    public static void print(int[] arr, int s, int e) {
        System.out.print("{ ");
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(" }");
        System.out.println();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        k = 0;
        i = left;
        while (i <= right) {
            arr[i++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 7,7,1,7,4,3,9,5,2,8,2,9 };

        mergeSort(arr, 0, arr.length - 1);

        print(arr, 0, arr.length - 1);
    }
}