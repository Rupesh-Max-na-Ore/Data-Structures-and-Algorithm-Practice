package Arrays.Easy; //q2
// Find Second Smallest and Second Largest Element in an array

import java.util.Arrays;

// 72

// 0
// Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

// Examples
// Example 1:
// Input:
//  [1,2,4,7,7,5]
// Output:
//  Second Smallest : 2
// 	Second Largest : 5
// Explanation:
//  The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2

// Example 2:
// Input:
//  [1]
// Output:
//  Second Smallest : -1
// 	Second Largest : -1
// Explanation:
//  Since there is only one element in the array, it is the largest and smallest element present in the array. There is no second largest or second smallest element present.
public class SecondMaxMin {

    public static void main(String[] args) {
        // way 1- use max and min variable - O(2n) 
        int[] array = {1, 8, 7, 56, 90};

        int max=array[0]; int min=max;
        System.out.println("Original array: " + Arrays.toString(array));
        // first id. the max and min elems.
        for(int i=1;i<array.length;i++){
            if(array[i]>max) max=array[i];
            if(array[i]<min) min=array[i];
        }
        System.out.println("way 1 result ----");
        System.out.println("Largest in array: " + max);
        System.out.println("Smallest in array: " + min);

        // then id. the 2nds based on above
        int secondMax=Integer.MIN_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]<max && array[i]>secondMax) secondMax=array[i];
            if(array[i]>min && array[i]<secondMin) secondMin=array[i];
        }
        System.out.println("2nd Largest in array: " + secondMax);
        System.out.println("2nd Smallest in array: " + secondMin);
        //op-
        //         Original array: [1, 8, 7, 56, 90]
        // Largest in array: 90
        // Smallest in array: 1
        // 2nd Largest in array: 56
        // 2nd Smallest in array: 7


        

        //way 2- Apply 2 passes of Bubble sort and give back a[2nd last index] - O(2n)
        System.out.println("way 2 result ----");
        //for 2nd largest
        for(int i=0;i<2;i++) //only 2 pass
        {
            for(int j=1;j<=array.length-1-i;j++){
                if(array[j-1]>array[j]) {//swap
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        secondMax=array[array.length-2];
        System.out.println("2nd Largest in array: " + secondMax);

        //for second smallest
        for(int i=0;i<2;i++) //only 2 pass
        {
            for(int j=array.length-1-2;j>=1+i;j--){//going R to L
                //-2 as I can skip checking last 2 elems as they are alredy largest 2, not gonna be smallest
                if(array[j-1]>array[j]) {//swap
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        secondMin=array[1];
        System.out.println("2nd Smallest in array: " + secondMin);

        //way3 - optimized way 1 - O(n)
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        secondMax=Integer.MIN_VALUE;
        secondMin=Integer.MAX_VALUE;

        for(int j=0;j<=array.length-1;j++){
            if(array[j]>max) {
                secondMax=max; //corected seqn
                max=array[j];
                //secondMax=max; //fatal mistake
            }else if (array[j] > secondMax && array[j] != max) {
                secondMax = array[j];}

            if(array[j]<min){//w/o else if, if 1st elem is smallest, gibs wrong answer
                secondMin= min; //corected seqn
                min=array[j];
                //secondMin= min; //fatal
            }else if (array[j] < secondMin && array[j] != min) {
                secondMin = array[j];
            }
        }
        System.out.println("way 3 result ----");
        System.out.println("2nd Largest in array: " + secondMax);
        System.out.println("2nd Smallest in array: " + secondMin);
        System.out.println("Largest in array: " + max);
        System.out.println("Smallest in array: " + min);

    }
    
}

//GFG submission 
//no 1

// //User function Template for Java

// class Solution {
//     int print2largest(int array[], int n) {
//         // code here
//         int max=Integer.MIN_VALUE;
//         int secondMax=Integer.MIN_VALUE;
//         for(int j=0;j<=n-1;j++){
//             if(array[j]>max) {
//                 secondMax=max; //corected seqn
//                 max=array[j];
//                 //secondMax=max; //fatal mistake
//             }else if (array[j] > secondMax && array[j] != max) {
//                 secondMax = array[j];}
//         }
        
//         return secondMax;
//     }
// }
// Test Cases Passed: 
// 150 /271
// failed case : 
//         21
// 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642 642
//saying op must be -1

//no 2
//User function Template for Java

// class Solution {
//     int print2largest(int array[], int n) {
//         // code here
//         int max=-1;
//         int secondMax=-1;
//         for(int j=0;j<=n-1;j++){
//             if(array[j]>max) {
//                 secondMax=max; //corected seqn
//                 max=array[j];
//                 //secondMax=max; //fatal mistake
//             }else if (array[j] > secondMax && array[j] != max) {
//                 secondMax = array[j];}
                
                
//         }
        
//         return secondMax;
//     }
// }

//question was little different, didn't read