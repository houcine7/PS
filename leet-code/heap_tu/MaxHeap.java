package heap_tu;

import java.util.Arrays;

public class MaxHeap {
    int[] arr;
    int maxSize;
    int heapSize;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heapSize = 0;
        this.arr = new int[maxSize];
    }

    // restoring the max heap property from an index:
    void maxHeapify(int i) {

        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * 2 + 2;
        int max = i;

        if (leftChildIndex < this.maxSize && arr[leftChildIndex] > arr[i]) {
            max = leftChildIndex;
        }
        if (rightChildIndex < this.maxSize && arr[rightChildIndex] > arr[i]) {
            max = rightChildIndex;
        }

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            maxHeapify(max);
        }

    }

    // remove the max of the heap
    int removeMax() {

        if (this.heapSize <= 0) {
            return Integer.MIN_VALUE;
        }
        if (this.heapSize == 1) {
            this.heapSize--;
            return arr[0];
        }

        int max = arr[0];
        arr[0] = arr[this.heapSize - 1];
        this.heapSize--;
        this.maxHeapify(0);
        return max;
    }

    /*
     * Increase key so the heap property is valid for the sub-trees
     * Of I because we increased the value we need to check the parents
     */
    void increaseKey(int i, int newValue) {
        arr[i] = newValue;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }

    }

    void deleteElement(int i) {
        // arr[i] = arr[this.heapSize - 1];
        // this.heapSize--;
        // maxHeapify(i);

        increaseKey(i, Integer.MAX_VALUE);
        removeMax();
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * @param key
     */
    void insertKey(int key) {
        if (heapSize == maxSize) {
            System.out.println("The heap is already full");
            return;
        }
        heapSize++;
        int i = heapSize - 1;
        arr[i] = key;

        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    int lChildIndex(int i) {
        return 2 * i + 1;
    }

    int rChildIndex(int i) {
        return 2 * i + 2;
    }

    int getMax() {
        return arr[0];
    }

    int currSize() {
        return this.heapSize;
    }

    // print the heap
    void printHeap() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(15);

        // Asking the user to input the keys:
        int k, i, n = 6;
        System.out.println("Entered 6 keys:- 3, 10, 12, 8, 2, 14 \n");
        h.insertKey(3);
        h.insertKey(10);
        h.insertKey(12);
        h.insertKey(8);
        h.insertKey(2);
        h.insertKey(14);

        h.printHeap();

        // of the heap.
        System.out.println("The current size of the heap is "
                + h.currSize() + "\n");

        // Printing the root element which is
        // actually the maximum element.
        System.out.println("The current maximum element is " + h.getMax()
                + "\n");

        // Deleting key at index 2.
        h.deleteElement(2);

        h.printHeap();

        // Printing the size of the heap
        // after deletion.
        System.out.println("The current size of the heap is "
                + h.currSize() + "\n");

        // Inserting 2 new keys into the heap.
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of the heap is "
                + h.currSize() + "\n");
        System.out.println("The current maximum element is " + h.getMax()
                + "\n");
    }

}

/*
 * 2i+1= left_child
 * => what is the parent of 2i+1=k
 * 2i+2=k
 * 2i+2= right_child
 * 
 */