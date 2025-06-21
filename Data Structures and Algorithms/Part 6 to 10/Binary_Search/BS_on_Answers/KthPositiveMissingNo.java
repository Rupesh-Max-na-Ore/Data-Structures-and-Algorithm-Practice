package Binary_Search.BS_on_Answers;
/*
 * Q7
 * Kth Missing Positive Number

Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'. 
Find the 'kth' positive integer missing from 'vec'.

Examples
Example 1:
Input Format:
 vec[]={4,7,9,10}, k = 1
Result:
 1
Explanation:
 The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing element is 1.
Example 2:
Input Format:
 vec[]={4,7,9,10}, k = 4
Result:
 5
Explanation:
 The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing element is 5.
 */
public class KthPositiveMissingNo {
    public static int findKthPositive(int[] a, int k) {

        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int missing = a[m] - (m + 1);
            if (missing < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return k + r + 1; //== k+l == k+LL+1
    }

    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
        int ans = findKthPositive(vec, k);
        System.out.println("The missing number is: " + ans);
    }
}
