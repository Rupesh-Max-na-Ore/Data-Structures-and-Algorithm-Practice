package Sorting;
import java.util.*;
//q3
//Problem Statement: Given an array of N integers, write a program to implement the Insertion sorting algorithm.
//Iterative


class InsertionSort {

    private int[] arrayCopy;

    InsertionSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallyInsertionSort(int[] A) {
        int i, j;
        
        //int pass=A.length-1;
        int key;
        int keyVal;
        i=0;
        while(i<A.length-1){
            key=i+1;
            keyVal=A[key];
            j=i;
            while(j>=0 && A[j]>keyVal){
                A[j+1]=A[j];
                j--;

            } A[j+1]=keyVal;
            i++;

        }

        return A;
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
        InsertionSort ss = new InsertionSort(A);
        int[] sortedArray = ss.ActuallyInsertionSort(ss.arrayCopy);
        ss.PrintArray(sortedArray);
        
}
}


