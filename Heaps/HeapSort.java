package Heaps;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 7, 4, 6, 0 };
        sort(arr);

        for (int a: arr) {
            System.out.println(a);
        }
    }

    public static void sort(int[] arr) {
        // build max heap
        for (int i = arr.length/2; i >= 0; i--) {
            heapify(i, arr.length, arr);
        }

        // sort, pick first (largest), put to end
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // push largest to end (swap)

            heapify(0, i, arr); // fix max heap
        }
    }

    public static void heapify(int idx, int size, int[] arr) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int maxIdx = idx;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != idx) {
            swap(arr, maxIdx, idx); // swap with largest
            heapify(maxIdx, size, arr); // fix children
        }

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
