package Arrays.Medium;
// //q14
// 560. Subarray Sum Equals K
// Medium
// Topics
// Companies
// Hint
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.2M
// Submissions
// 2.8M
// Acceptance Rate
// 43.6%

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubarrsSumEqK {

    public static int subarraySum(int[] A, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum=0;
        int cnt=0;
        
        for (int num : A){
            sum += num;
            if(sum == k) cnt++;
            if(prefixSum.containsKey(sum-k)) 
                cnt += prefixSum.get(sum-k);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return cnt;

  
    }
    public static void main(String[] args) {
        int[] a1 = {5,1,4,2,3,4,3,2};//{-1,-1,0,3,-3,4,-5,6,-7};
        int [] a2 = {-1,-2,3};
        int [] a3={1,1,1,1,1,1,2,2,3,3,2,1};
        int [] a4={-1,-1,1};
        System.out.println("Original array: " + Arrays.toString(a4));
        int  cnt= CountSubarrsSumEqK.subarraySum(a4,0);
        System.out.println("Count of no. of subarr: "+cnt);
        }
    
}

//failed for many cases
// public static int subarraySum(int[] a, int k) {
//     int n=a.length; int i,j;
//     int sum=a[0];
//     for(i=1;i<n;i++){
//         sum+=a[i];
//         a[i]=sum;
//     }
//     System.out.println("PrefixSum[] array: " + Arrays.toString(a));

//     int cnt=0;

//     for(i=n-1;i>=0;i--){
//         for(j=i-1;j>=0;j--){
//             if(a[i]-a[j]==k) cnt++;
//         }
//     } return cnt;
// }

//works for all cases, very slow
// public static int subarraySum(int[] a, int k) {
//     int n=a.length; int i,j;
//     int prefixSum[]=new int[n+1];
//     prefixSum[0]=0;
//     int sum=a[0];
//     prefixSum[1]=a[0];
//     for(i=1;i<n;i++){
//         sum+=a[i];
//         prefixSum[i+1]=sum;
//     }
//     System.out.println("PrefixSum[] array: " + Arrays.toString(prefixSum));

//     int cnt=0;

//     for(i=n;i>=0;i--){
//         for(j=i-1;j>=0;j--){
//             if(prefixSum[i]-prefixSum[j]==k) cnt++;
//         }
//     } return cnt;
// }

//also works, even lower SC, but still slow
// class Solution {
//     public int subarraySum(int[] a, int k) {
//         int n=a.length; int i,j;
//         int sum=a[0];
//         for(i=1;i<n;i++){
//             sum+=a[i];
//             a[i]=sum;
//         }
//         //System.out.println("PrefixSum[] array: " + Arrays.toString(a));
    
//         int cnt=0;
    
//         for(i=n-1;i>=0;i--){
//             for(j=i-1;j>=0;j--){
//                 if(a[i]-a[j]==k) cnt++;
//             }
//             if(a[i]-0==k) cnt++; //right
//         } 
//         //if(a[0]-0==k) cnt++; //wrong
//         return cnt;
//     }
// }

//
// public static int subarraySum(int[] a, int k) {
//     //brute force, works with -ves too
//     int n=a.length; int i,j;
//     int sum=a[0];
//     for(i=1;i<n;i++){
//         sum+=a[i];
//         a[i]=sum;
//     }
//     System.out.println("PrefixSum[] array: " + Arrays.toString(a));

//     int cnt=0;

//     for(i=n-1;i>=0;i--){
//         for(j=i-1;j>=0;j--){
//             if(a[i]-a[j]==k) cnt++;
//         }
//         if(a[i]-0==k) cnt++;
//     } 
    
//     return cnt;
// }

//was working on this, but doesn't work if negatives in array
  //     //brute force, works with -ves too
    //     int n=a.length; int i,j;
    //     int prefixSum[]=new int[n+1];
    //     prefixSum[0]=0;
    //     int sum=a[0];
    //     prefixSum[1]=a[0];
    //     for(i=1;i<n;i++){
    //         sum+=a[i];
    //         prefixSum[i+1]=sum;
    //     }

    //     int cnt=0;

    //     int l=0;int r=1;
    //     while (l<=n && r<=n && l<r) { //if(r<n)r++;
    //         if(l<r)
    //         {
    //             if(prefixSum[r]-prefixSum[l]==k ){
    //             r++;
    //             cnt++;
    //             continue;
    //         }
    //         else if(prefixSum[r]-prefixSum[l]<k ){r++;continue;}
    //         else if(prefixSum[r]-prefixSum[l]>k ){l++;continue;}
    //         r++;
    //     }
        
        
    // }return cnt;