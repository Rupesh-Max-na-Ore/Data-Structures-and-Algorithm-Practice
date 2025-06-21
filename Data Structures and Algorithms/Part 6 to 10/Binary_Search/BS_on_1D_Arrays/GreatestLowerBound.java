package Binary_Search.BS_on_1D_Arrays;

public class GreatestLowerBound {
    //== finding floor
    static int GLB_Finder(long a[], int n, long k)
    {
        int l=0; int r=n-1; int GLB=-1; // Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<=k) {GLB=m; l=m+1;}
            else if(a[m]>k)  r=m-1;
            
            //else if(a[m]==k) return m;// can also do this
        }
        return GLB;
    }
    
}
// //gfg floor Q submission
// class Solution{
    
//     // Function to find floor of x
//     // arr: input array
//     // n is the size of array
//     static int findFloor(long a[], int n, long k)
//     {
//         int l = 0, r = n - 1, GLB = -1; // Initialize variables

//     while (l <= r) {
//         int m = l + (r - l) / 2;

//         if (a[m] <= k) {
//             GLB = m; // Update GLB to the current mid index
//             l = m + 1; // Move right to find a potentially closer floor value
//         } else {
//             r = m - 1; // Move left
//         }
//     }

//     return GLB; // Return the index of the greatest lower bound, or -1 if no floor exists
//     }
    
// }
