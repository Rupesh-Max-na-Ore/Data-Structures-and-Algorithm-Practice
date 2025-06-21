package Sorting;
import java.util.Arrays;

//q7
//Problem Statement:  Given an array of n integers, sort the array using the Quicksort method.
//Recursive, do iterative(later)


//2nd attempt, revise, few corrections

public class QuickSort {
    private int[] arrayCopy;

    public QuickSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallyQuickSort(int[] A, int l, int r) {
        if (l < r) {
            int q = partition(A, l, r);
            ActuallyQuickSort(A, l, q - 1);
            ActuallyQuickSort(A, q + 1, r);
        }
        return A;
    }

    private int partition(int[] a, int l, int r) {
        
        int i = l + 1;
        int j = r;
        int pivot = a[l];

        while (i <= j) {
            while (i <= j && a[i] <= pivot)  i++;
            
            while (i <= j && a[j] > pivot) j--;
            if (i < j)  Swap(a, i, j);
        }
        Swap(a, l, j);
        return j;
    }

    public void Swap(int A[], int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    public void PrintArray(int A[]) {
        System.out.print("[");
        for (int i = 0; i < A.length - 1; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.print(A[A.length - 1] + "]");
    }

    public static void main(String[] args) {
        int[] A = {11, 2, 5, 7, 90, 55, 33, 23, 27};
        QuickSort ss = new QuickSort(A);
        int[] sortedArray = ss.ActuallyQuickSort(ss.arrayCopy, 0, A.length - 1);
        ss.PrintArray(sortedArray);
    }
}


//1st attempt, few  mistakes
// package Sorting;

// import java.util.Arrays;

// public class QuickSort {
//     private int[] arrayCopy;

//     QuickSort(int[] A) {
//         arrayCopy = Arrays.copyOf(A, A.length);
//     }

//     public int[] ActuallyQuickSort(int[] A,int l, int r) {
//         if(l==r) return A;

//         else{
//             int q = partition(A,l,r);
//             ActuallyQuickSort(A, l, q-1);
//             ActuallyQuickSort(A, q+1, r);
//         }
        
//         return A;
//     }

//     private int partition(int[] a, int l, int r) {
//         int i=l+1;
//         int j=r;
//         int pivot=a[l];
//         while(i<=j){
//             while(i<=j && a[i]<=pivot) i++;
//             while(i<=j && a[j]> pivot) j--;
//             if(i<j){
//                 Swap(a, j, i);
//                 //i++;j--; //mostake
//             }}
//             Swap(a, j, l);
//             return j;
        
//     }

//     public void Swap(int A[], int x, int y) {
//         int temp = A[x];
//         A[x] = A[y];
//         A[y] = temp;
//     }
//     public void PrintArray(int A[]){
//         System.out.print("[");
//         for (int i = 0; i < A.length-1; i++) {
//             System.out.print(A[i] + ", ");
//         }
//         System.out.print(A[A.length-1]+"]");
//     }

    

//     public static void main(String[] args) {
//         int[] A = {11, 2, 5, 7, 90, 55, 33, 23, 27};
//         QuickSort ss = new QuickSort(A);
//         int[] sortedArray = ss.ActuallyQuickSort(ss.arrayCopy,0,A.length-1);
//         ss.PrintArray(sortedArray);
        
// }
// }
