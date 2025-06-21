package Sorting;

import java.util.Arrays;
//q5
//Problem Statement: Given an array of N integers, write a program to implement the Recursive Bubble Sort algorithm.
//Recursive
public class RecursiveBubbleSort {
    private int[] arrayCopy;

    RecursiveBubbleSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallyRecursiveBubbleSort(int[] A,int l) {
        if(l==0||l==1) return A;

        //Perform 1 pass of Bubble SOrt
        //shift max elem to ->most
        BubblePass(A,l);

        //Recursively Shift next highest elem to -> most
        //continually for (decrerasing by  1) subarray
        ActuallyRecursiveBubbleSort(A,l-1);

        return A;
    }

    private void BubblePass(int[] a, int l) {
        //Pass counter fn
        if(l==1) return;

        int i=0;
        BubbleSwap(a,l,i);

        BubblePass(a, l-1);
    }

    private void BubbleSwap(int[] a, int l, int i) {
        if(i>=l-1) return;
        //compare ith elem with right adjacent elem
        if(a[i]>a[i+1]) Swap(a, i+1, i);
        BubbleSwap(a, l, i+1);
    }

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
        RecursiveBubbleSort ss = new RecursiveBubbleSort(A);
        int[] sortedArray = ss.ActuallyRecursiveBubbleSort(ss.arrayCopy,A.length);
        ss.PrintArray(sortedArray);
        
}
}
