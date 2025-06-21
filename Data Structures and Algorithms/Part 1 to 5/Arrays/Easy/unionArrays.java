package Arrays.Easy;
//q9
// Union of Two Sorted Arrays
// MediumAccuracy: 31.39%Submissions: 205K+Points: 4
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

import java.util.ArrayList;
import java.util.Arrays;

// banner
// Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. Return the elements in sorted order.

// Example 1:

// Input: 
// n = 5, arr1[] = {1, 2, 3, 4, 5}  
// m = 5, arr2 [] = {1, 2, 3, 6, 7}
// Output: 
// 1 2 3 4 5 6 7
// Explanation: 
// Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
// Example 2:

// Input: 
// n = 5, arr1[] = {2, 2, 3, 4, 5}  
// m = 5, arr2[] = {1, 1, 2, 3, 4}
// Output: 
// 1 2 3 4 5
// Explanation: 
// Distinct elements including both the arrays are: 1 2 3 4 5.
// Example 3:

// Input:
// n = 5, arr1[] = {1, 1, 1, 1, 1}
// m = 5, arr2[] = {2, 2, 2, 2, 2}
// Output: 
// 1 2
// Explanation: 
// Distinct elements including both the arrays are: 1 2.
// Your Task: 
// You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays.

// Expected Time Complexity: O(n+m).
// Expected Auxiliary Space: O(n+m).

// Constraints:
// 1 <= n, m <= 105
// -109 <= arr1[i], arr2[i] <= 109
import java.util.ArrayList;

public class unionArrays {
//works but time out on gfg due to continual use of list.contains()- increases TC
    // public static ArrayList<Integer> unionOf2Arrays(int []a,int[]b){
    //     int m=a.length;
    //     int n=b.length;
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int i=0;
    //     int j=0;
    //     int k=0;
    //     while (i<m && j<n){
    //         if(a[i]==b[j]){
    //             if (!list.contains(a[i])) {
    //                 list.add(a[i]);
    //             }
    //             ++k;++i;++j;
    //         }
    //         else if(a[i]>b[j]){
    //             if (!list.contains(b[j])) {
    //                 list.add(b[j]);
    //             }
    //             ++k;++j;
    //         }
    //         else if(a[i]<b[j]){
    //             if (!list.contains(a[i])) {
    //                 list.add(a[i]);
    //             }
    //             ++k;++i;
    //         }
    // }
    // while (i>=m && j<n) {
    //     if (!list.contains(b[j])) {
    //         list.add(b[j]);
    //     }
    //     ++j;++k;
    // }
    // while (j>=n && i<m){
    //     if (!list.contains(a[i])) {
    //         list.add(a[i]);
    //     }
    //     ++i;++k;
    // }
    // System.out.println("No. of elems. in union:"+k);
    // return list;
// }
    public static void main(String[] args) {
        int[] a1 = {-1,-1,3,3,4,5};
        int[] a2 = {-1,-2,3};
        
        System.out.println("Original array: " + Arrays.toString(a1));

        //sortedRotate r1=new sortedRotate(a1);

        System.out.println("Original array: " + Arrays.toString(a2));
        //sortedRotate r2=new sortedRotate(a2);
        ArrayList<Integer> list = findUnion(a1, a2,a1.length,a2.length);
        System.out.println(list.toString());
    }
    public static ArrayList<Integer> findUnion(int a[], int b[], int m, int n)
    {
         ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;int last;
        while (i<m && j<n){
            //if(list.size()!=0) last= list.get(list.size()-1);//causes compilation errors
            if(a[i]<=b[j]){
                if (list.size()==0||list.get(list.size()-1)!=a[i]) {
                    list.add(a[i]);
                }
                ++i;//++j; //causes reps. why?
            }
            else //if(a[i]>b[j]){
                {if (list.size()==0||list.get(list.size()-1)!=b[j]) {
                    list.add(b[j]);
                }
                ++j;
            }
            // else {
            //     if (list.size()==0||list.get(list.size()-1)!=a[i]) {
            //         list.add(a[i]);
            //     }
            //     ++i;
            // }
    }
    while (j<n) {
        //last= list.get(list.size()-1);
        if (list.get(list.size()-1)!=b[j]) {
            list.add(b[j]);
        }
        ++j;
    }
    while (i<m){
        //= list.get(list.size()-1);
        if (list.get(list.size()-1)!=a[i]) {
            list.add(a[i]);
        }
        ++i;
    }
    
    return list;

    }
}

//gfg submission
//     //User function Template for Java

// //arr1,arr2 : the arrays
// // n, m: size of arrays
// class Solution
// {
//     //Function to return a list containing the union of the two arrays.
//     public static ArrayList<Integer> findUnion(int a[], int b[], int m, int n)
//     {
//          ArrayList<Integer> list = new ArrayList<>();
//         int i=0;
//         int j=0;
//         while (i<m && j<n){

//             if(a[i]<=b[j]){
//                 if (list.size()==0||list.get(list.size()-1)!=a[i]) {
//                     list.add(a[i]);
//                 }
//                 ++i;
//             }
//             else 
//                 {if (list.size()==0||list.get(list.size()-1)!=b[j]) {
//                     list.add(b[j]);
//                 }
//                 ++j;
//             }
//     }
//     while (j<n) {

//         if (list.get(list.size()-1)!=b[j]) {
//             list.add(b[j]);
//         }
//         ++j;
//     }
//     while (i<m){
 
//         if (list.get(list.size()-1)!=a[i]) {
//             list.add(a[i]);
//         }
//         ++i;
//     }
    
//     return list;

// }
// }





