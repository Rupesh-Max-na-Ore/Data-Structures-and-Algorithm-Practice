package Arrays.Medium;

import java.util.Arrays;

public class MaxPairwiseSumOfSmallestsInSubarr {
    public static long pairWithMaxSum(long a[], long n)
    {
        int l=0;
        int r=1;
        long s=0;
        long m=0;
        while(l<n-1){
            
            s=a[l]+a[r];
            if(m<s) m=s;
            l++;r++;
        
        }return m;

    }

    public static void main(String[] args) {
        long[] a1 = {5,1,4,2,3,4,3,2};//{-1,-1,0,3,-3,4,-5,6,-7};
        long [] a2 = {-1,-2,3};
        
        System.out.println("Original array: " + Arrays.toString(a1));
        long max=MaxPairwiseSumOfSmallestsInSubarr.pairWithMaxSum(a1,a1.length);
        System.out.println("Sum of max subarr: "+max);
        }
}

//gfg submission
//{ Driver Code Starts
//Initial Template for Java

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
// 	public static void main(String[] args) throws IOException
// 	{
// 	        BufferedReader br =
//             new BufferedReader(new InputStreamReader(System.in));
//         int t =
//             Integer.parseInt(br.readLine().trim()); // Inputting the testcases
//         while(t-->0)
//         {
//             long n = Long.parseLong(br.readLine().trim());
//             long a[] = new long[(int)(n)];
//             String inputLine[] = br.readLine().trim().split(" ");
//             for (int i = 0; i < n; i++) {
//                 a[i] = Long.parseLong(inputLine[i]);
//             }
            
//             Solution obj = new Solution();
//             System.out.println(obj.pairWithMaxSum(a, n));
            
//         }
// 	}
// }


// } Driver Code Ends


//User function Template for Java

// class Solution {
    
//     public static long pairWithMaxSum(long a[], long n)
//     {
//                 int l=0;
//         int r=1;
//         long s=0;
//         long m=0;
//         while(l<n-1){
            
//             s=a[l]+a[r];
//             if(m<s) m=s;
//             l++;r++;
        
//         }return m;


//     }
// }