package Heaps;

import java.util.*;

public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void add(T e) {
        heap.add(e);

        int currIdx = heap.size() - 1;
        int parentIdx = getParentIndex(currIdx);

        while (currIdx > 0 && heap.get(currIdx).compareTo(heap.get(parentIdx)) < 0) {
            swapByIdx(currIdx, parentIdx);
            currIdx = parentIdx;
            parentIdx = getParentIndex(currIdx);
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("No elements");
        }

        // swap first and last
        swapByIdx(0, heap.size() - 1);

        // remove last
        T el = heap.remove(heap.size() - 1);

        // fix heap
        heapify(0);

        return el;
    }

    public T peek() {
        if (!isEmpty()) {
            return heap.get(0);
        }

        throw new NoSuchElementException("No elements");
    }

    private void heapify(int idx) {
        int left = getChildLeft(idx);
        int right = getChildRight(idx);

        // find minimum among  root, left child and right child
        int min = idx;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(min)) < 0) {
            min = left;
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(min)) < 0) {
            min = right;
        }

        // swap root value with left child or right child
        if (min != idx) {
            swapByIdx(min, idx);
            heapify(min);
        }
    }

    private void swapByIdx(int a, int b) {
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    private int getParentIndex(int idx) {
        return (idx - 1)/2;
    }

    private int getChildLeft(int idx) {
        return 2 * idx + 1;
    }

    private int getChildRight(int idx) {
        return 2 * idx + 2;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

}
