package Arrays.Easy;
// q1
// Largest Element in Array
// BasicAccuracy: 67.48%Submissions: 223K+Points: 1
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

import java.util.Arrays;

// banner
// Given an array A[] of size n. The task is to find the largest element in it.
 

// Example 1:

// Input:
// n = 5
// A[] = {1, 8, 7, 56, 90}
// Output:
// 90
// Explanation:
// The largest element of given array is 90.
 

// Example 2:

// Input:
// n = 7
// A[] = {1, 2, 0, 3, 2, 4, 5}
// Output:
// 5
// Explanation:
// The largest element of given array is 5.
 

// Your Task:  
// You don't need to read input or print anything. 
// Your task is to complete the function largest() which takes the array A[] and 
// its size n as inputs and returns the maximum element in the array.

 

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

 

// Constraints:
// 1 <= n<= 103
// 0 <= A[i] <= 103
// Array may contain duplicate elements.

public class Max {

    public static void main(String[] args) {
        // way 1- use max variable - O(n) - Best way
        int[] array = {1, 8, 7, 56, 90, 22};
        int max=array[0];
        System.out.println("Original array: " + Arrays.toString(array));
        for(int i=1;i<array.length;i++){
            if(array[i]>max) max=array[i];
        }
        System.out.println("way 1 result ----");
        System.out.println("Largest in array: " + max);

       


        //way 3- use 1 pass of bubble sort - then gib last elem - O(1n) - vey imp.

        for(int i=0;i<1;i++) //only 1 pass
        {
            for(int j=1;j<=array.length-1-i;j++){
                if(array[j-1]>array[j]) {//swap
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }

        max=array[array.length-1];
        System.out.println("way 3 result ----");
        System.out.println("Condn. of array after 1 pass of Bubble Sort: " + Arrays.toString(array));


        System.out.println("Largest in array: " + max);

         //way 2- sort and output last index elem. -O(nlogn)
        // Sorting the array
        Arrays.sort(array);
        // Printing the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));
        max=array[array.length-1];
        System.out.println("way 2 result ----");

        System.out.println("Largest in array: " + max);
    }
    
}

//GFG submission
// class Compute {
    
//     public int largest(int array[], int n)
//     {
//         // way 1- use max variable - O(n) - Best way
        
//         int max=array[0];
//         //System.out.println("Original array: " + Arrays.toString(array));
//         for(int i=1;i<n;i++){
//             if(array[i]>max) max=array[i];
//         }
//         return max;
        
//     }
// }