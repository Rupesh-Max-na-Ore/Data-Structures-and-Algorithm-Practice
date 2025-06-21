package Sorting;
import java.util.*;

//q1
//Problem Statement: Given an array of N integers, write a program to implement the Selection sorting algorithm.
//Recursive

class RecursiveSelectionSort {

    private int[] arrayCopy;

    RecursiveSelectionSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallyRecursiveSelectionSort(int[] A, int n, int startI, int lastI) {
        if(startI>lastI) return A;
        
        int minI=findMinI(A,startI,startI+1);
        if(minI!=startI) Swap(A, startI, minI);
        ActuallyRecursiveSelectionSort(A, n, startI+1, lastI);

        return A;
    }

    private int findMinI(int[] A, int minI, int i) {
        if(i>=A.length) return minI;
        if(A[i]<A[minI]) minI=i;
        return findMinI(A, minI, i+1);
    }

    public void Swap(int A[], int x, int y) {
        //Don't use this method of swapping in JAVA
        // A[x] = A[x] + A[y]; 
        // A[y] = A[x] - A[y]; 
        // A[x] = A[x] - A[y]; 
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
        RecursiveSelectionSort ss = new RecursiveSelectionSort(A);
        int[] sortedArray = ss.ActuallyRecursiveSelectionSort(ss.arrayCopy,A.length,0,A.length-1);
        ss.PrintArray(sortedArray);
        
}
}