//q13&14 same with some difference that changes optimal strategies
/*
 * Longest Sub-Array with Sum K
MediumAccuracy: 24.64%Submissions: 232K+Points: 4
Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

banner
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function lenOfLongSubarr() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1<=N<=105
-105<=A[i], K<=105
 
 * 
 */

package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubArray {

    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int k) {
        // //Complete the function
        //Only works for positive nos. - O(n)
        // int l=0;int r=0; int cnt=0; int max=0; int sum=0;
        // while(r<N){
        //     sum+=A[r];
        //     if(sum<k) {
        //         r++;
        //         //sum+=A[r-1];
        //     }
        //     else if(sum>k){
        //         l++;
        //         //l=r;//fatal
        //         r=l;
        //         sum=0;
        //     }
        //     else if(sum==k){
        //         //r++;
                
        //         cnt=r-l+1;
        //         max=(max<cnt)? cnt:max;
        //         cnt=0;sum=0;
        //         l++;
        //         //l=r;//fatal
        //         r=l;

        //     }
            
        // }return max;


        // workd for negatives as well - O(nlogn)
        Map<Integer, Integer> HM = new HashMap<>();
        int sum = 0;
        int maxu = 0;
        for (int i = 0; i < N; i++) {
            //calc. the prefix sum till index i
            sum += A[i];

            // if the sum = k, update the maxu
            if (sum == k) {
                maxu = Math.max(maxu, i + 1);
            }

            // calc. the sum of remaining part, that is,= x-k
            int rem = sum - k;

            //calc. the length and update maxu
            if (HM.containsKey(rem)) {
                int len = i - HM.get(rem);
                maxu = Math.max(maxu, len);
            }

            //update the map checking the conditions
            if (!HM.containsKey(sum)) {
                HM.put(sum, i);
            }
        }

        return maxu;

    }
    public static void main(String[] args) {
        int[] arr = {1,15,1,1,1,1,1,1,1,1,1,1,2,1,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1};//{10,5,2,7,1,9};
        int k = 15;
        int maxs=lengthOfLongestSubArray.lenOfLongSubarr(arr,arr.length,k);
        System.out.println("len of largest subarr to sum "+ k +" = "+ maxs);//4

        int a[]={1, 4, 3, 3, 5, 5};
        int ka=16;
        int maxs1=lengthOfLongestSubArray.lenOfLongSubarr(a,a.length,ka);
        System.out.println("len of largest subarr to sum "+ ka +" = "+ maxs1); //5
    
        
    }

}

// //gfg submission
// Map<Integer, Integer> HM = new HashMap<>();
// int sum = 0;
// int maxu = 0;
// for (int i = 0; i < N; i++) {
//     //calc. the prefix sum till index i
//     sum += A[i];

//     // if the sum = k, update the maxu
//     if (sum == k) {
//         maxu = Math.max(maxu, i + 1);
//     }

//     // calc. the sum of remaining part, that is,= x-k
//     int rem = sum - k;

//     //calc. the length and update maxu
//     if (HM.containsKey(rem)) {
//         int len = i - HM.get(rem);
//         maxu = Math.max(maxu, len);
//     }

//     //update the map checking the conditions
//     if (!HM.containsKey(sum)) {
//         HM.put(sum, i);
//     }
// }

// return maxu;
