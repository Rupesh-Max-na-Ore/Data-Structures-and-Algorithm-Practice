package Binary_Search.BS_on_1D_Arrays;
/*
 * Q12
 * Search single elem. in sorted A[] with all others occurring twice.
 */
public class Single {
    public int SingleElem(int[]a, int n){
        if(n==1) return 0;
        if(a[0]!=a[1]) return 0;
        if(a[n-1]!=a[n-2]) return n-1;
        int l=0; int r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]!=a[m+1]&&a[m]!=a[m-1]){
                // mth is single elem
                return m;
            }
            if (((m%2==0)&&(a[m]==a[m+1]))||((m%2!=0)&&(a[m]==a[m-1]))) //(E,O) pair --> L to single elem
            {   
                l=m+1;// Shift srch space to R, where single elem exist
            }
            else if(((m%2!=0)&&(a[m]==a[m+1]))||((m%2==0)&&(a[m]==a[m-1]))) //(O,E) pair --> R to single elem
            {
                r=m-1;// Shift srch space to L, where single elem exist
            }
        } return -1;//never executed, given the Q specs.
    }
}
// //lc submission ,returning elem. instead of index
// class Solution {
//     public int singleNonDuplicate(int[] a) {
//         int n=a.length;
//         if(n==1) return a[0];
//         if(a[0]!=a[1]) return a[0];
//         if(a[n-1]!=a[n-2]) return a[n-1];
//         int l=1; int r=n-2;
//         while(l<=r){
//             int m=l+(r-l)/2;
//             if(a[m]!=a[m+1]&&a[m]!=a[m-1]){
//                 // mth is single elem
//                 return a[m];
//             }
//             if (((m%2==0)&&(a[m]==a[m+1]))||((m%2!=0)&&(a[m]==a[m-1]))) //(E,O) pair --> L to single elem
//             {   
//                 l=m+1;// Shift srch space to R, where single elem exist
//             }
//             else if(((m%2!=0)&&(a[m]==a[m+1]))||((m%2==0)&&(a[m]==a[m-1]))) //(O,E) pair --> R to single elem
//             {
//                 r=m-1;// Shift srch space to L, where single elem exist
//             }
//         } return -1;//never executed, given the Q specs.

//     }
// } 