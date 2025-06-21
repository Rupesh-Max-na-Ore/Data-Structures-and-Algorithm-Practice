package Sorting;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[minIndex])
            minIndex = left;
        
        if (right < size && heap[right] < heap[minIndex])
            minIndex = right;

        if (i != minIndex) {
            swap(i, minIndex);
            heapifyDown(minIndex);
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int extractMin() {
        if (size <= 0)
            throw new IllegalStateException("Heap is empty!");

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException("Heap is empty!");
        return heap[0];
    }

    private void resize() {
        int[] newHeap = new int[capacity * 2];
        System.arraycopy(heap, 0, newHeap, 0, capacity);
        heap = newHeap;
        capacity *= 2;
    }
    
    public void removeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        heap[index] = heap[size - 1];
        size--;
        heapifyDown(index);
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void heapSort(int[] array) {
        // S1: Build a min-heap from the input array
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }

        // S2: Extract elements from the min-heap and store them in the output array
        for (int i = 0; i < array.length; i++) {
            array[i] = extractMin();
        }
    }
}
