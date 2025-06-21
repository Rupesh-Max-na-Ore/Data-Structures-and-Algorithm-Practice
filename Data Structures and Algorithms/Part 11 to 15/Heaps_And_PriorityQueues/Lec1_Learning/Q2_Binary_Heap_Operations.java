package Heaps_And_PriorityQueues.Lec1_Learning;

public class Q2_Binary_Heap_Operations {
    
}
//First attempt TLE
// // User function Template for Java


// class MinHeap {
//     int[] harr;
//     int capacity;
//     int heap_size;
//     MinHeap(int cap) {
//         heap_size = 0;
//         capacity = cap;
//         harr = new int[cap];
//     }
//     int parent(int i) { return (i - 1) / 2; }
//     int left(int i) { return (2 * i + 1); }
//     int right(int i) { return (2 * i + 2); }

//     //Function to extract minimum value in heap and then to store 
//     //next minimum value at first index.
//     int extractMin()
//     {
//         if(heap_size==0) return -1;
//         int minRightNow= harr[0];//top elem == min in minHeap
//         //below block of if not required, just there to avoid more fn calls
//         if (heap_size == 1) {
//         heap_size--;
//         return harr[0];
//         }
//         harr[0]=harr[heap_size-1];//put last elem in top
//         heap_size--;//reduce size of heap by 1
//         MinHeapify(0);//percolate down now top elem to correct place
//         return minRightNow;
//     }

//     //Function to insert a value in Heap.
//     void insertKey(int k) 
//     {
//         int i;
//         if(heap_size==capacity) return; //can't insert
//         heap_size++;// to accomodate new elem k
//         i=heap_size-1;//last elem indx in i
//         //percolate up by replacing parents repeatedly until heap prop. gets satisfied
//         while(i>=0 && k>harr[parent(i)]){
//             //swap parent and curr child i
//             harr[i]= harr[parent(i)];
//             i=parent(i); // curr parent is the next itr child
//         }
//         //finally place k when loop ends, we are at the place apt for new elem placement
//         harr[i]=k;
//     }

//     //Function to delete a key at ith index.
//     void deleteKey(int i) 
//     {
//         if(i>=heap_size) return; //can't delete as ith elem not exist yet, so, do nothing
//         //below block works but takes time
//         // //int toDelete=harr[i];
//         // harr[i]=harr[heap_size-1];//replace ith elem w/ last elem
//         // heap_size--;//reduce size of heap
//         // MinHeapify(i);//percolate down replaced elem
//         decreaseKey(i, Integer.MIN_VALUE);
//         extractMin();
//     }

//     //Function to change value at ith index and store that value at first index.
//     void decreaseKey(int i, int new_val) 
//     {
//         harr[i] = new_val;
//         while (i != 0 && harr[parent(i)] > harr[i]) {
//             int temp = harr[i];
//             harr[i] = harr[parent(i)];
//             harr[parent(i)] = temp;
//             i = parent(i);
//         }
//     }

//     /* You may call below MinHeapify function in
//       above codes. Please do not delete this code
//       if you are not writing your own MinHeapify */
//     void MinHeapify(int i) {
//         int l = left(i);
//         int r = right(i);
//         int smallest = i;
//         if (l < heap_size && harr[l] < harr[i]) smallest = l;
//         if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
//         if (smallest != i) {
//             int temp = harr[i];
//             harr[i] = harr[smallest];
//             harr[smallest] = temp;
//             MinHeapify(smallest);
//         }
//     }
// }

/*//passed
class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }


    //Function to extract minimum value in heap and then to store 
    //next minimum value at first index.
    int extractMin() {
    if (heap_size == 0)
        return -1; // or throw an exception
    if (heap_size == 1) {
        heap_size--;
        return harr[0];
    }

    int root = harr[0];
    harr[0] = harr[heap_size - 1];
    heap_size--;
    MinHeapify(0);
    return root;
}


    //Function to insert a value in Heap.
    void insertKey(int k) {
    if (heap_size == capacity)
        return; // or throw an exception
    heap_size++;
    int i = heap_size - 1;
    harr[i] = k;
    while (i != 0 && harr[parent(i)] > harr[i]) {
        int temp = harr[i];
        harr[i] = harr[parent(i)];
        harr[parent(i)] = temp;
        i = parent(i);
    }
}


    void deleteKey(int i) {
    if (i < 0 || i >= heap_size)
        return; // or throw an exception
    decreaseKey(i, Integer.MIN_VALUE);
    extractMin();
}



    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) 
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    // You may call below MinHeapify function in
    //   above codes. Please do not delete this code
    //   if you are not writing your own MinHeapify 
      void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}

*/