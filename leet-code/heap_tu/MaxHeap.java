package heap_tu;

public class MaxHeap {
    int[] arr;
    int maxSize;
    int heapSize;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heapSize = 0;
        this.arr = new int[maxSize];
    }

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

    int parent(int i) {
        return (i - 1) / 2;
    }

}

/*
 * 2i+1= left_child
 * => what is the parent of 2i+1=k
 * 2i+2=k
 * 2i+2= right_child
 * 
 */