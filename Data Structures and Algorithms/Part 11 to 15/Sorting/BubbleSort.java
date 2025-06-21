package Sorting;

import java.util.Arrays;

//q2
//Problem Statement: Given an array of N integers, write a program to implement the Bubble Sorting algorithm
//Iterative, Improved version
public class BubbleSort {
    private int[] arrayCopy;

    BubbleSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallyBubbleSort(int[] A) {
        int i;
        //Improved/optimized BubbleSOrt
        int swapped=1;
        int pass;
        for(pass=A.length-1;pass>=0 && swapped==1;pass--){
            swapped=0;
            for(i=0;i<=(pass-1);i++){
                if(A[i]>A[i+1]){
                    Swap(A, i, i+1);
                    swapped=1;
                }
            }
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
        BubbleSort ss = new BubbleSort(A);
        int[] sortedArray = ss.ActuallyBubbleSort(ss.arrayCopy);
        ss.PrintArray(sortedArray);
        
}
}
