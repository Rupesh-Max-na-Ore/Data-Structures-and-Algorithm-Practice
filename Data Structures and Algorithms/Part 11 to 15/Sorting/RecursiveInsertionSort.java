package Sorting;
import java.util.*;
//q6
//Problem Statement: Given an array of N integers, write a program to implement the Recursive Insertion Sort algorithm.
//Recursive
class RecursiveInsertionSort {

    private int[] arrayCopy;

    RecursiveInsertionSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallyRecursiveInsertionSort(int[] A) {
        int i=1;
        int l=A.length;
        InsertPass(A,l,i);
        return A;
    }

    private void InsertPass(int[] a, int l, int i) {
        if(i>l-1){return;}
        int key=a[i];
        int j=i-1;
        InsertKeyShift(a,l,i,key,j);

        InsertPass(a, l, i+1);
    }

    private void InsertKeyShift(int[] a, int l, int i, int key, int j) {
        if(j<0||key>a[j]){//be careful, I did j==0, took so much time to identify and fix
            a[j+1]=key; return;
        }
        a[j+1]=a[j];

        InsertKeyShift(a, l, i, key, j-1);

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
        RecursiveInsertionSort ss = new RecursiveInsertionSort(A);
        int[] sortedArray = ss.ActuallyRecursiveInsertionSort(ss.arrayCopy);
        ss.PrintArray(sortedArray);
        
}
}


