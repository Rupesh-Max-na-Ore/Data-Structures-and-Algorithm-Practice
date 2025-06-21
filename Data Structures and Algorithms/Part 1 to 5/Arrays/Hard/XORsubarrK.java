package Arrays.Hard;
// //q6
// Count the number of subarrays with given xor K


// 15

// 1
// Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

// Pre-requisite: Find the number of subarrays with the sum K

// Examples
// Example 1:
// Input Format:
//  A = [4, 2, 2, 6, 4] , k = 6
// Result:
//  4
// Explanation:
//  The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

// Example 2:
// Input Format:
//  A = [5, 6, 7, 8, 9], k = 5
// Result:
//  2
// Explanation:
//  The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class XORsubarrK {
    public static int subarraysWithXorK(int []a, int k) {
        int n = a.length; 
        int x0r = 0; int cnt = 0;
        Map<Integer, Integer> preXORhistory = new HashMap<>();
        // Insert  (0,1) in HM to detect cases where prefix XOR == k directly
        preXORhistory.put(0, 1); 
        int x;
        for (int i = 0; i < n; i++) {
            // current prefix XOR till i
            x0r = x0r ^ a[i];

            x = x0r ^ k;

             cnt+=(preXORhistory.containsKey(x))?preXORhistory.get(x):0; //works, but not easily understandable 
            // if (preXORhistory.containsKey(x)) {
            //     cnt += preXORhistory.get(x);
            // }

            // Insert the prefix XOR till i, with curr_freq= prev_freq + 1
            preXORhistory.put(x0r, preXORhistory.getOrDefault(x0r,0) + 1);
            
        }return cnt;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println("Original array: " + Arrays.toString(a));
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}

//code 360 submission

// import java.io.*;
// import java.util.* ;

// import java.util.ArrayList;

// public class Solution {
// 	public static int subarraysXor(ArrayList<Integer> a, int k) {
// 		// Write your code here.
// 		        int n = a.size(); 
//         int x0r = 0; int cnt = 0;
//         Map<Integer, Integer> preXORhistory = new HashMap<>();
//         // Insert  (0,1) in HM to detect cases where prefix XOR == k directly
//         preXORhistory.put(0, 1); 
//         int x=0;
//         for (int i = 0; i < n; i++) {
//             // current prefix XOR till i
//             x0r = x0r ^ a.get(i);

//             x = x0r ^ k;

//              cnt+=(preXORhistory.containsKey(x))?preXORhistory.get(x):0; //works, but not easily understandable 
//             // if (preXORhistory.containsKey(x)) {
//             //     cnt += preXORhistory.get(x);
//             // }

//             // Insert the prefix XOR till i, with curr_freq= prev_freq + 1
//             preXORhistory.put(x0r, preXORhistory.getOrDefault(x0r,0) + 1);
            
//         }return cnt;

// 	}
// }

