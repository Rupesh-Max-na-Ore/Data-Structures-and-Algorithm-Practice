package Sorting;

import java.util.Arrays;
//q4
//Problem:  Given an array of size n, sort the array using Merge Sort.
//Recursive, do Iterative(later)
public class MergeSort {
    private int[] arrayCopy;

    MergeSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }
    private void ActuallyMergeSort(int[] A, int L, int R) {
        if (L < R) {
            int mid = (L + R) / 2;

            ActuallyMergeSort(A, L, mid);
            ActuallyMergeSort(A, mid + 1, R);

            merge(A, L, mid, R);
        }}

        private void merge(int[] a, int l, int mid, int r) {
            int[] b = new int[r - l + 1];
            int i = l;
            int j = mid + 1;
            int k = 0;
    
            while (i <= mid && j <= r) {
                if (a[i] <= a[j]) {
                    b[k++] = a[i++];
                } else {
                    b[k++] = a[j++];
                }
            }
    
            while (i <= mid) {
                b[k++] = a[i++];
            }
    
            while (j <= r) {
                b[k++] = a[j++];
            }
    
            for (int ind = l; ind <= r; ind++) {
                a[ind] = b[ind - l];
            }
        }    
    //1st Attempt, few mistakes
    // public int[] ActuallyMergeSort(int[] A,int L, int R) {
    //     if(L>=R) return A;
    //     int mid=(L+R)/2;

    //     ActuallyMergeSort(A, L, mid);
    //     ActuallyMergeSort(A, mid+1, R);

    //     merge(A,L,mid,R);

    //     return A;
    // }

    // private void merge(int[] a, int l, int mid, int r) {
    //     int [] b=new int[r-l+1];
    //     int i=l;int j = mid+1; int k=0;

    //     while(i<=mid && j<=r){
    //         if(a[i]<=a[j]){
    //             b[k]=a[i]; i++;k++;
    //         } 
    //         if(a[j]>a[i]){
    //             b[k]=a[j];j++;k++;
    //         }}
    //         //if(i<=mid){
    //             while(i<=mid){
    //                 b[k++]=a[i++];
    //             }
    //         //}else{
    //             while(j<=r){
    //                 b[k++]=a[j++];
    //             }
    //         //}
        
    //     for(int ind = l;ind<=r;ind++){
    //         a[ind]=b[ind-l];
    //     }
    // }

    public void Swap(int A[], int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
    public void PrintArray(int A[]){
        System.out.print("[");
        for (int i = 0; i < A.length-1; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.print(A[A.length-1]+"]");
    }

    

    public static void main(String[] args) {
        int[] A = {11, 2, 5, 7, 90, 55, 33, 23, 27};
        MergeSort ss = new MergeSort(A);
        //int[] sortedArray = ss.ActuallyMergeSort(ss.arrayCopy,0,A.length-1);
        ss.ActuallyMergeSort(A, 0, A.length - 1);
        //ss.PrintArray(sortedArray);
        ss.PrintArray(A);
        
}
}
