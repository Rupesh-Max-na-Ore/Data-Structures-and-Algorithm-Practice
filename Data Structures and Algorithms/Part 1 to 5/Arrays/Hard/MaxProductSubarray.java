package Arrays.Hard;
// //q12
// 152. Maximum Product Subarray
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, find a 
// subarray
//  that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.3M
// Submissions
// 3.6M
// Acceptance Rate
// 35.1%
public class MaxProductSubarray {
    //way 2 - using prefix pdt and suffix pdt around 0s
    public static int maxProductSubArray(int[] A) {
        int n = A.length; 
        int pre = 1, suff = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //re-set pre and suff to 1 if encountered zero in prev iteration
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= A[i];
            suff *= A[n - i - 1];
            // update max to pre or suff or max, whichever is greatest
            max = (max>pre)? (max>suff)? max:suff : (pre>suff)? pre:suff;
            // or just use --> max = Math.max(max, Math.max(pre, suff));
        }
        return max;
    }

    //way 3 - using modified Kadane's algo
    static int maxProductSubArray2(int A[]) {
        int max=A[0];
        int currMax=A[0];
        int currMin=A[0];
        for(int i=1; i < A.length; i++){
            // //turns out code works w/o this if too, which makes sense given conditional update of currMax  & currMin
            // if(A[i]==0) { // actually gibs wrong for some cases
            //     currMax=1;
            //     currMin=1;
            //     continue;//skip iteration updates
            // }
            int tmp1 = currMax * A[i]; int tmp2 = currMin * A[i]; //store in temp vars for comparison & readability
            currMax = (A[i]>tmp1)? (A[i]>tmp2)? A[i]:tmp2 : (tmp1>tmp2)? tmp1:tmp2;
            // or just use --> currMax = Math.max(currMax, Math.max(tmp1, tmp2));
            currMin = (A[i]<tmp1)? (A[i]<tmp2)? A[i]:tmp2 : (tmp1<tmp2)? tmp1:tmp2;
            // or just use --> currMin = Math.min(currMin, Math.min(tmp1, tmp2));

            max=(max>currMax)? max:currMax;
        } return max;
    }
    

    public static void main(String[] args) {
        int[] A = {1, 2, -3, 0, -4, -5};
        int maximum = maxProductSubArray(A);
        System.out.println("The maximum product subarray is: " + maximum);
    }
    
}

// lc submission 1
// public int maxProduct(int[] A) {
//     int n = A.length; 
//     int pre = 1, suff = 1;
//     int max = Integer.MIN_VALUE;
//     for (int i = 0; i < n; i++) {
//         if (pre == 0) pre = 1;
//         if (suff == 0) suff = 1;
//         pre *= A[i];
//         suff *= A[n - i - 1];
//         max = (max>pre)? (max>suff)? max:suff : (pre>suff)? pre:suff;
//     }
//     return max;
// }

//lc submission 2, best soln
// class Solution {
//     public int maxProduct(int[] A) {
//         int max=A[0];
//         int currMax=A[0];
//         int currMin=A[0];
//         for(int i=1; i < A.length; i++){
            
//             int tmp1 = currMax * A[i]; int tmp2 = currMin * A[i]; //store in temp vars for comparison & readability
//             currMax = (A[i]>tmp1)? (A[i]>tmp2)? A[i]:tmp2 : (tmp1>tmp2)? tmp1:tmp2;
//             // or just use --> currMax = Math.max(currMax, Math.max(tmp1, tmp2));
//             currMin = (A[i]<tmp1)? (A[i]<tmp2)? A[i]:tmp2 : (tmp1<tmp2)? tmp1:tmp2;
//             // or just use --> currMin = Math.min(currMin, Math.min(tmp1, tmp2));

//             max=(max>currMax)? max:currMax;
//         } return max;
//     }
// }

// //lc submission 3
// class Solution {
//     public int maxProduct(int[] A) {
//         if (A == null || A.length == 0) {
//             return 0;
//         } // to improve some best cases

//         int maxProduct = A[0];
//         int currMax = A[0];
//         int currMin = A[0];
            // beauty of this soln. is the recognition that we can just swap currMin and currMax when encounter -ve A[i]
//         for (int i = 1; i < A.length; i++) {
//             if (A[i] < 0) {
//                 // Swap currMax and currMin when encountering a negative number
//                 int temp = currMax;
//                 currMax = currMin;
//                 currMin = temp;
//             }
//             int tmp1 = currMax * A[i]; int tmp2 = currMin * A[i];
//             currMax = (A[i]>tmp1)? A[i]:tmp1;
//             currMin = (A[i]<tmp2)? A[i]:tmp2;

//             maxProduct = Math.max(maxProduct, currMax);
//         }

//         return maxProduct;
//     }
// }

// ANother way to write, actually same way 3
    // static int maxProductSubArray2(int A[]) {
    //     int P1 = A[0], P2 = A[0], result = A[0];
        
    //     for(int i=1;i<A.length;i++) {
    //         int tmp = Math.max(A[i], Math.max(P1*A[i], P2*A[i]));
    //         P2 = Math.min(A[i], Math.min(P1*A[i], P2*A[i]));
    //         P1 = temp;
            
    //         result = Math.max(result, P1);
    //     }
        
    //     return result;
    //     }