package Binary_Search.BS_on_1D_Arrays;
/*
 * Q13 Peak
 */
public class Peak {
    //== Finding global maxima in unsorted A[] -->O(n) at best cuz Linear Search only option
    //== Finding Discontinuity in Montonicity in Bitonic A[] -->O(log n) cuz can apply Binary Technique
    // Can find Through/Dip too in Bitonic A[], in similar fashion
    int PeakOfBitonic(int[]a, int n){
        if(n==1) return a[0];
        if(a[0]>a[1]) return a[0];
        if(a[n-1]>a[n-2]) return a[n-1];
        int l=0; int r=n-1;
        while(l<=r){
        int m=l+(r-l)/2;
        // a[m] > adjacent elems --> a[m]==peak
        if(a[m]>a[m+1]&&a[m]>a[m-1]) return a[m];    
        else if(a[m]>=a[m-1]) l=m+1; // Restrict srch space to R
        else if(a[m]<=a[m-1]) r=m-1; // Restrict srch space to L
        } return -1;// never executed given Q specs.
    }
    int DipOfBitonic(int[]a, int n){
        if(n==1) return a[0];
        if(a[0]<a[1]) return a[0];
        if(a[n-1]<a[n-2]) return a[n-1];
        int l=0; int r=n-1;
        while(l<=r){
        int m=l+(r-l)/2;
        // a[m] > adjacent elems --> a[m]==peak
        if(a[m]<a[m+1]&&a[m]<a[m-1]) return a[m];    
        else if(a[m]>=a[m-1]) r=m-1; // Restrict srch space to L
        else if(a[m]<=a[m-1]) l=m+1; // Restrict srch space to R
        } return -1;// never executed given Q specs.
    }

    
}
// lc submission to retutrn index
// class Solution {
//     public int findPeakElement(int[] a) {
//         int n=a.length;
//         if(n==1) return 0;
//         if(a[0]>a[1]) return 0;
//         if(a[n-1]>a[n-2]) return n-1;
//         int l=1; int r=n-2;
//         while(l<=r){
//         int m=l+(r-l)/2;
//         // a[m] > adjacent elems --> a[m]==peak
//         if(a[m]>a[m+1]&&a[m]>a[m-1]) return m;    
//         else if(a[m]>=a[m-1]) l=m+1; // Restrict srch space to R
//         else if(a[m]<=a[m-1]) r=m-1; // Restrict srch space to L
//         } return -1;// never executed given Q specs.
//     }
// }