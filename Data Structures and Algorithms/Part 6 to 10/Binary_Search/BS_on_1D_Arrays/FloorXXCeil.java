package Binary_Search.BS_on_1D_Arrays;
/*
 * Q5
 * Floor and Ceil in Sorted Array
Problem Statement: You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
The floor of x is the largest element in the array which is smaller than or equal to x.
The ceiling of x is the smallest element in the array greater than or equal to x.

Pre-requisite: Lower Bound & Binary Search

Example 1:
Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
Result: 4 7
Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Example 2:
Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
Result: 8 8
Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
 */
public class FloorXXCeil {
    static int findFloor(int[] a, int n, int x) {
        int l=0; int r=n-1; int GLB=-1; // Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<=x) {GLB=m; l=m+1;}
            else if(a[m]>x)  r=m-1;
            
        }
        return GLB;
    }

    static int findCeil(int[] a, int n, int x) {
        int l=0; int r=n-1; int LUB=n; // Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<x) l=m+1;
            else if(a[m]>=x) {LUB=m; r=m-1;}
        }
        return LUB;
    }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int f = findFloor(a, n, x);
        int c = findCeil(a, n, x);
        return new int[] {f, c};
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.println("The floor and ceil are: " + ans[0]
                           + " " + ans[1]);

                           int[] try1 = FloorAndCeil(arr, n, x);
                           System.out.println("The floor and ceil are: " + try1[0]
                                              + " " + try1[1]); // it worked in this TC
    }

    // Curious whether combined ceil  and floor srch will work or not
    // Turns out it work for most cases, leaving edge cases, where it goes infinite loop, atleast in gfg
    public static int[] FloorAndCeil(int []a , int n, int x){
        int l=0; int r=n-1; int GLB=-1; int LUB=-1;// Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<x) // left shift srch space
            {GLB=m; l=m+1;}
            else if(a[m]>x)  // right shift srch space
            {LUB=m; r=m-1;}
            else if(a[m]==x)
            {GLB=m;LUB=m;}
            
        }
        return new int[] {GLB, LUB};
    }
    
}

// //gfg submission 3, overlooked some details in 1 and 2
// class Solve {
//     // Actually, Linear Search will gib faster answer for this Q, as a[] is Unsorted
//     // Used Binary Search anyway, as that is the chapter name
//     Pair getFloorAndCeil(int[] a, int n, int x) {
//         Arrays.sort(a);
//         int f = findFloor(a, n, x);
//         int c = findCeil(a, n, x);
//         return  new Pair(f,c);
//     }
    
//     static int findFloor(int[] a, int n, int x) {
//         int l=0; int r=n-1; int GLB=-1; // Random Ini.
//         while(l<=r)
//         {
//             int m = l+(r-l)/2;
//             if(a[m]<=x) {GLB=m; l=m+1;}
//             else if(a[m]>x)  r=m-1;
            
//         }
//         if(GLB==-1) return -1;
//         return a[GLB];
//     }

//     static int findCeil(int[] a, int n, int x) {
//         int l=0; int r=n-1; int LUB=-1; // Random Ini.
//         while(l<=r)
//         {
//             int m = l+(r-l)/2;
//             if(a[m]<x) l=m+1;
//             else if(a[m]>=x) {LUB=m; r=m-1;}
//         }
//         if(LUB==-1) return -1;
//         return a[LUB];
//     }
    
// }

// //gfg submission 4, failed 19/360
// class Solve {
//     // Actually, Linear Search will gib faster answer for this Q, as a[] is Unsorted
//     // Used Binary Search anyway, as that is the chapter name
//     Pair getFloorAndCeil(int[] a, int n, int x) {.
//         Arrays.sort(a);
//         int [] fc = FloorAndCeil(a, n, x);
        
//         return  new Pair(fc[0],fc[1]);
//     }
    
//     public static int[] FloorAndCeil(int []a , int n, int x){
//         int l=0; int r=n-1; int GLB=-1; int LUB=-1;// Random Ini.
//         while(l<=r)
//         {
//             int m = l+(r-l)/2;
//             if(a[m]<x) // left shift srch space
//             {GLB=m; l=m+1;}
//             else if(a[m]>x)  // right shift srch space
//             {LUB=m; r=m-1;}
//             else if(a[m]==x)
//             {GLB=m;LUB=m;}
            
//         }
//         if(GLB==-1 && LUB==-1) return new int[] {-1,-1};
//         //int f=-1; int c=-1;
//         if(GLB==-1 && LUB!=-1) return new int[] {-1,a[LUB]};
//         if(LUB==-1 && GLB!=-1) return new int[] {a[GLB],-1};
        
//         // if(GLB!=-1) f= a[GLB];
//         // if(LUB!=-1) c= a[LUB];
        
//         return new int[] {a[GLB],a[LUB]};
//     }
// }

// //code 360 submission
// import java.util.* ;
// import java.io.*; 

// public class Solution {
//     public static int[] getFloorAndCeil(int[] a, int n, int x) {
//       // Wriute your code here.
//       int f = findFloor(a, n, x);
//         int c = findCeil(a, n, x);
//         return new int[] {f, c};
//     }
//     static int findFloor(int[] a, int n, int x) {
//         int l=0; int r=n-1; int GLB=-1; // Random Ini.
//         while(l<=r)
//         {
//             int m = l+(r-l)/2;
//             if(a[m]<=x) {GLB=m; l=m+1;}
//             else if(a[m]>x)  r=m-1;
            
//         }
//         return GLB == -1 ? -1 : a[GLB];
//     }

//     static int findCeil(int[] a, int n, int x) {
//         int l=0; int r=n-1; int LUB=-1; // Random Ini.
//         while(l<=r)
//         {
//             int m = l+(r-l)/2;
//             if(a[m]<x) l=m+1;
//             else if(a[m]>=x) {LUB=m; r=m-1;}
//         }
//         return LUB == -1 ? -1 : a[LUB];
//     }
   
    
// }