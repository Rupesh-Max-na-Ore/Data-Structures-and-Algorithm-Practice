package Binary_Search.BS_on_Answers;
/*
 * Q5
 * Find the Smallest Divisor Given a Threshold

Problem Statement: You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given threshold value.

Examples
Example 1:
Input Format:
 N = 5, arr[] = {1,2,3,4,5}, limit = 8
Result:
 3
Explanation:
 We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

Example 2:
Input Format:
 N = 4, arr[] = {8,4,2,3}, limit = 10
Result:
 2
Explanation:
 If we choose 1, we get 17 as the sum. If we choose 2, we get 9(4+2+1+2) <= 10 as the answer. So, 2 is the answer.



Point to remember:

While dividing the array elements with a chosen number, we will always take the ceiling value. And then we will consider their summation. For example, 3 / 2 = 2.
Observation: 

Minimum possible divisor: We can easily consider 1 as the minimum divisor as it is the smallest positive integer.
Maximum possible divisor: If we observe, we can conclude the maximum element in the array i.e. max(arr[]) is the maximum possible divisor. Any number > max(arr[]), will give the exact same result as max(arr[]) does. This divisor will generate the minimum possible result i.e. n(1 for each element), where n = size of the array.
With these observations, we can surely say that our answer will lie in the range 
[1, max(arr[])].
 */
public class SmallestDivisor {
    public int smallestDivisor(int[] a, int lt) {
        int n=a.length;
        if(lt<n) return -1; // can't go dividing faster, atleast 1 division per a[i] is the limit
        int max=a[0]; // find max in a[i] and sum of all elems.
        long sum=a[0];
        for(int i=1; i<n; i++) 
        {   
            max=(a[i]>max)? a[i]:max;
            sum+=a[i];
        }
        if(lt==n) return max; // need to get +1 per a[i], no more
        if(sum<=lt) return 1; //  No need to divide, sum is already less than or equal to the lt

        //Ini. for BinSrch
        int l=1; int r=max; int d=max; // d store ans
        while(l<=r){
            int m=l+(r-l)/2;
            long cntD=0; // long to prevent overflow
            for(int t:a){
                cntD+=(t+m-1)/m; // == ceil (t/m)
                if(cntD>lt) break; // this was the optimization I was looking for
                if(cntD>=lt) break; // fails, see case a = [7,1,3,1,1,1,1,1,1,1], lt=16, expected =2, o/p=1
                //if(cntD<=lt) break; // I though this would help with large cases, but it disturbs rest
            }
            if(cntD<=lt)
            {
                d=m;
                r=m-1; // try to get lower dividend that still nets sum of quotient over a[] <=lt
            }
            else l=m+1; // try to go higher (increase the divisor)
        } return d;
    }

    public static void main(String[] args) {
        SmallestDivisor sd = new SmallestDivisor();

        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int limit1 = 8;
        System.out.println("Test Case 1:");
        System.out.println("Input: arr = {1, 2, 3, 4, 5}, limit = 8");
        System.out.println("Output: " + sd.smallestDivisor(arr1, limit1)); // Expected output: 3

        // Test case 2
        int[] arr2 = {8, 4, 2, 3};
        int limit2 = 10;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: arr = {8, 4, 2, 3}, limit = 10");
        System.out.println("Output: " + sd.smallestDivisor(arr2, limit2)); // Expected output: 2
    }
}
