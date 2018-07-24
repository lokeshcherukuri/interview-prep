package heaps;

import java.util.Arrays;

public class MaxHeap {

    public void swap(int[] a , int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void heapify(int[] a) {
        int maxIndex = a.length-1;
        for (int rootIndex=maxIndex/2; rootIndex>=0; ) {
            int leftIndex = rootIndex*2+1,
                rightIndex = rootIndex*2+2;

            int largest = rootIndex;
            if (leftIndex <= maxIndex && a[rootIndex] < a[leftIndex]) {
                largest = leftIndex;
            }
            if (rightIndex <= maxIndex && a[largest] < a[rightIndex]) {
                largest = rightIndex;
            }

            if (largest != rootIndex) {
                swap(a, rootIndex, largest);
                if (largest <= maxIndex/2) {
                    rootIndex = largest;
                } else {
                    rootIndex--;
                }
            } else {
                rootIndex--;
            }
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        int[] a = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        heap.heapify(a);
        System.out.print(Arrays.toString(a));
    }
}
