package Sorting;
import java.util.*;
//q1
//Problem Statement: Given an array of N integers, write a program to implement the Selection sorting algorithm.
//Iterative

class SelectionSort {

    private int[] arrayCopy;

    SelectionSort(int[] A) {
        arrayCopy = Arrays.copyOf(A, A.length);
    }

    public int[] ActuallySelectionSort(int[] A) {
        int i, j;
        int min;
        for (i = 0; i < A.length - 1; i++) {
            min = i;
            for (j = i+1 ; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            Swap(A, min, i);
        }
        return A;
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
        SelectionSort ss = new SelectionSort(A);
        int[] sortedArray = ss.ActuallySelectionSort(ss.arrayCopy);
        ss.PrintArray(sortedArray);
        
}
}


// import java.util.*;

// class SelectionSort{

//     SelectionSort(int [] A)
//     {
//         int [] a=A;

//     }

//     public int [] ActuallySelectionSort(int [] A)
//     {
//         int i,j;
//         int min; //int swapped=0;
//         for(i=0;i<A.length-1;i++){
//             min=i;
//             for(j=i+1;j<A.length;j++){
//                 if(A[j]<A[min]){
//                     min=j;
//                     //swapped=1;
//                 }
                

//             }Swap(A,min,i);

//         }
//         return A;

        
//     }

//     public void Swap(int A[], int x, int y) {
//         A[x] = A[x] + A[y]; // Add the value of A[y] to A[x]
//         A[y] = A[x] - A[y]; // Subtract the original value of A[y] from the sum stored in A[x], which effectively stores the value of A[x] in A[y]
//         A[x] = A[x] - A[y]; // Subtract the new value of A[y] from the sum stored in A[x], which effectively stores the original value of A[y] in A[x]
//     }
    

//     // public void Swap(int A[],int x, int y){
//     //     // int a=A[x];int b=A[y];
//     //     // a=a+b;//say a=1,b=4, a+b->a=5
//     //     // b=a-b;//a-b->b=1
//     //     // a=a-b;//a-b->a=4
//     //     // A[x]=a;A[y]=b;
//     // }

//     public static void main(String[] args) {
//         int [] A={11,2,5,7,90,55,33,23,27};
//         SelectionSort ss = new SelectionSort(A);
//         int[] sortedArray = ss.ActuallySelectionSort(A);
//         for (int i = 0; i < sortedArray.length; i++) {
//             System.out.print(sortedArray[i] + " ");
//     }

// }}