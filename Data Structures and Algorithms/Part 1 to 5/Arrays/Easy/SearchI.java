package Arrays.Easy;

public class SearchI {
//q8
// Searching an element in a sorted array
// BasicAccuracy: 48.03%Submissions: 184K+Points: 1
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!


// banner
// Given an array arr[] sorted in ascending order of size N and an integer K. Check if K is present in the array or not.


// Example 1:

// Input:
// N = 5, K = 6
// arr[] = {1,2,3,4,6}
// Output: 1
// Exlpanation: Since, 6 is present in 
// the array at index 4 (0-based indexing),
// output is 1.
 

// Example 2:

// Input:
// N = 5, K = 2
// arr[] = {1,3,4,5,6}
// Output: -1
// Exlpanation: Since, 2 is not present 
// in the array, output is -1.
 

// Your Task:
// You don't need to read input or print anything. Complete the function searchInSorted() which takes the sorted array arr[], its size N and the element K as input parameters and returns 1 if K is present in the array, else it returns -1. 


// Expected Time Complexity: O(Log N)
// Expected Auxiliary Space: O(1)

 

// Constraints:
// 1 <= N <= 106
// 1 <= K <= 106
// 1 <= arr[i] <= 106
// public class SearchI {


    SearchI(){

    }

//     public static int BinSrch(int a[],int k)
//     {
//         int l=0;
//         int r=a.length;
//         int i=0;
//         while (l<=r) 
//         {   i++;
//             int m=l+(r-l)/2;
//             if(a[m]==k) return i;//m;
//             if(a[m]<k) l=m+1;
//             else r=m-1;
//         }
//         return i;//-1;
    
//     }
//     public static int InterSrch(int a[],int k)
//     {
//         int l=0;
//         int r=a.length-1;
//         int i=0;
//         while (l<=r) 
//         {
//             i++;
//             int m=l+((k-a[l])/(a[r]-a[l]))*(r-l);
            
//             if(a[m]==k) return i;//m;
//             if(a[m]<k) l=m+1;
//             else r=m-1;
//         }
//         return i;//-1;
//     }
//     public static int LinSrch(int a[], int k){
//         for(int i=0;i<a.length;i++){
//             if(a[i]==k) return k;
//             if(a[i]>k) return -1;
//         }
//         return -1;
//     }
    public static void main(String[] args) {
        int[] arr = {-101,10,22,35,47,58,69,73,86,420,42069};
        int k = 86;
    
        //Search rd = new Search();

        //int srchI=Search.BinSrch(arr, k);
        System.out.println(SearchI.BinSrch(arr, k));
        System.out.println(SearchI.InterSrch(arr, k));
    }
    

//modified methods that gib no. of iterations

public static int BinSrch(int a[],int k)
{
    int l=0;
    int r=a.length;
    int i=0;
    while (l<=r) 
    {   i++;
        int m=l+(r-l)/2;
        if(a[m]==k) return i;//m;
        if(a[m]<k) l=m+1;
        else r=m-1;
    }
    return i;//-1;

}
public static int InterSrch(int a[],int k)
{
    int l=0;
    int r=a.length-1;
    int i=0;
    while (l<=r) 
    {
        i++;
        int m=l+((k-a[l])/(a[r]-a[l]))*(r-l);
        
        if(a[m]==k) return i;//m;
        if(a[m]<k) l=m+1;
        else r=m-1;
    }
    return i;//-1;
}
public static int LinSrch(int a[], int k){
    for(int i=0;i<a.length;i++){
        if(a[i]==k) return k;
        if(a[i]>k) return -1;
    }
    return -1;
}

//gfg submission
// class Solution{
//     static int searchInSorted(int a[], int N, int k)
//     {
        
//         // Your code here
//         int l=0;
//         int r=N-1;
//         while (l<=r) 
//         {   
//             int m=l+(r-l)/2;
//             if(a[m]==k) return 1;
//             if(a[m]<k) l=m+1;
//             else r=m-1;
//         }
//         return -1 ;       
//     }
// }
}
