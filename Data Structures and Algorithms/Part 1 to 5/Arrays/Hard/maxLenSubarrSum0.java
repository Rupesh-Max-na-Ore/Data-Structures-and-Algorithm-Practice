package Arrays.Hard;
// //q5
// Largest subarray with 0 sum
// MediumAccuracy: 41.84%Submissions: 277K+Points: 4
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

import java.util.Arrays;

// banner
// Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

// Example 1:

// Input:
// N = 8
// A[] = {15,-2,2,-8,1,7,10,23}
// Output: 5
// Explanation: The largest subarray with
// sum 0 will be -2 2 -8 1 7.
// Your Task:
// You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 <= N <= 105
// -1000 <= A[i] <= 1000, for each valid i
import java.util.HashMap;

public class maxLenSubarrSum0 {
    public static int maxLen(int a[], int n)
    {
        HashMap<Integer,Integer> historyS=new HashMap<>();
        int max=0; int s=0; historyS.put(0,-1);// for if(s==0) max=i+1;
        int i=0;int p=0;//any val, change anyway in loop
        while(i<n){
            s+=a[i]; 
            if(historyS.get(s)==null) historyS.put(s,i);
            else {
                p=i-historyS.get(s);
                max=(max<p)? p:max;
            }i++;
        }return max;
    }

    public static void maxLenSubarrSum0Print(int[] a, int n){//no need if commented code
        HashMap<Integer,Integer> historyS=new HashMap<>();// store s:i pair
        // HashMap<Integer,Integer> RevhistoryS=new HashMap<>();// store i:s pair
        // HashMap<Integer,Integer> Ltrack=new HashMap<>();// store L:s pair
        int max=0; int s=0; historyS.put(0,-1); //RevhistoryS.put(-1,0);// for if(s==0) max=i+1;
        int i=0;int p=0;//any val, change anyway in loop
        int maxL=0,maxR=0;
        while(i<n){
            s+=a[i]; 
            if(historyS.get(s)==null) historyS.put(s,i);
            else {
                p=i-historyS.get(s);// curr i - earliest same s
                if(max<p){
                    max=p;
                    maxR=i;
                    maxL=historyS.get(s)+1;

                }
            }i++;
        }
        //int[] subarray = Arrays.copyOfRange(arr, start, end + 1); // end is exclusive, be careful to ++
        //System.out.println(Arrays.toString(subarray));

        int[] subarray = Arrays.copyOfRange(a, maxL, maxR+1);
        System.out.println("Subarray with sum=0 : "+Arrays.toString(subarray));
    }

    public static void main(String[] args) {
        int[] a={7,1,-1,3,2,-2,-8,1,7,10,23};
        System.out.println("Original array: " + Arrays.toString(a));
        System.out.println("max subarr len with sum =0 : "+maxLenSubarrSum0.maxLen(a, a.length));
        maxLenSubarrSum0.maxLenSubarrSum0Print(a, a.length);
    }
}
//gfg submission
// class GfG
// {
//     int maxLen(int a[], int n)
//     {
//         HashMap<Integer,Integer> historyS=new HashMap<>();
//         int max=0; int s=0; historyS.put(0,-1);// for if(s==0) max=i+1;
//         int i=0;
//         while(i<n){
//             s+=a[i];
//             if(historyS.get(s)==null) historyS.put(s,i);
//             else {
//                 //int p=i-historyS.get(s);
//                 max=(max<i-historyS.get(s))? i-historyS.get(s):max;
//             }i++;
//         }return max;
//     }
    
// }