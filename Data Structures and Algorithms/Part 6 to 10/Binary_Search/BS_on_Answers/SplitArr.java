package Binary_Search.BS_on_Answers;
/*
 * Q11
 * Split Array - Largest Sum
Problem Statement: Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
A subarray is a contiguous part of the array.

Pre-requisite: BS-18. Allocate Books or Book Allocation | Hard Binary Search

Examples
Example 1:
Input Format:
 N = 5, a[] = {1,2,3,4,5}, k = 3
Result:
 6
Explanation:
 There are many ways to split the array a[] into k consecutive subarrays. The best way to do this is to split the array a[] into [1, 2, 3], [4], and [5], where the largest sum among the three subarrays is only 6.

Example 2:
Input Format:
 N = 3, a[] = {3,5,1}, k = 3
Result:
 5
Explanation:
 There is only one way to split the array a[] into 3 subarrays, i.e., [3], [5], and [1]. The largest sum among these subarrays is 5.
Upon close observation, we can understand that this problem is similar to the problem: BS-18. Allocate Books or Book Allocation | Hard Binary Search. In that case, we had to allocate books to the students. But actually, we were dividing that given array based on the subarray sum. We will do the same in this case.

Assume the given array is {10, 20, 30, 40} and k = 2. Now, we can split the array in the following ways:

10 | 20, 30, 40  → Maximum subarray sum  = 90
10, 20 | 30, 40  → Maximum subarray sum = 70
10, 20, 30 | 40  → Maximum subarray sum = 60
From the above allocations, we can clearly observe that in the last case, the maximum subarray sum is the minimum possible. So, 60 will be the answer.

Observations:

Minimum possible answer: We will get the minimum answer when we split the array into n subarrays(i.e. Each subarray will have a single element). Now, in this case, the maximum subarray sum will be the maximum element in the array. So, the minimum possible answer is max(arr[]).
Maximum possible answer: We will get the maximum answer when we put all n elements into a single subarray. The maximum subarray sum will be the summation of array elements i.e. sum(arr[]). So, the maximum possible answer is sum(arr[]).
From the observations, it is clear that our answer lies in the range [max(arr[]), sum(arr[])].

How to calculate the number of subarrays we need to make if the maximum subarray sum can be at most ‘maxSum’:

In order to calculate the number of subarrays we will write a function, countPartitions(). This function will take the array and ‘maxSum’ as parameters and return the number of partitions.

countPartitions(arr[], maxSum):

We will first declare two variables i.e. ‘partitions’(stores the no. of partitions), and ‘subarraySum’(stores the sum of the current subarray). As we are starting with the first subarray, ‘partitions’ should be initialized with 1.
We will start traversing the given array.
If subarraySum + arr[i] <= maxSum: If upon adding the current element with ‘subarraySum’ does not exceed ‘maxSum’, we can insert this i-th element to the current subarray.
Otherwise, we will move to the next subarray(i.e. partitions += 1 ) and insert the i-th element into that.
Finally, we will return the value of ‘partitions’.
 */
public class SplitArr {
    public int splitArray(int[] a, int k) {
        int n=a.length;
        if(n<k) return -1;
        int sum=a[0]; int max=a[0];
        for(int i=1; i<n;i++){
            sum+=a[i];
            max=(a[i]>max)? a[i]:max;
        }
        if(n==k) return max;
        if(n==1) return sum;
        int l=max; int r=sum;
        while(l<=r){
            int m=l+(r-l)/2; // m=maxSumAllowed
            if(NumberOfSubarrays(a,n,m,k) <= k ) r=m-1;
            else l=m+1;
        } return l;
    }

    private int NumberOfSubarrays(int[] a, int n, int maxSumAllowed, int k) {
        int SubArrCnt=1;
        int SubArrSum=a[0];
        for(int j=1;j<n;j++){
            if(a[j]+SubArrSum<=maxSumAllowed) SubArrSum+=a[j];
            else {
                SubArrCnt++;
                if(SubArrCnt>k) return SubArrCnt;
                SubArrSum=a[j];    
            }
        }return SubArrCnt;
    }

    public static void main(String[] args) {
        SplitArr splitArr = new SplitArr();

        // Test cases
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Input: arr = {1, 2, 3, 4, 5}, k = 3");
        System.out.println("Output: " + splitArr.splitArray(arr1, k1)); // Expected output: 6

        int[] arr2 = {3, 5, 1};
        int k2 = 3;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: arr = {3, 5, 1}, k = 3");
        System.out.println("Output: " + splitArr.splitArray(arr2, k2)); // Expected output: 5
    }
}

