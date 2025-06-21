package Binary_Search.BS_on_1D_Arrays;
/*
 * Q10 Min. in Rotated Sorted A[]
 * //Merged with Max. cuz why not
 */
public class MinRotArr {
    public int[] MinXXMax(int[] a,int n){
        int l=0; int r=n-1; int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        while(l<=r){
            int m= l+(r-l)/2;
            if(a[l]<=a[r]) // == (a[l]<=a[m]<=a[r]), when whole subarray is sorted
            {
                min=(a[l]<min)?a[l]:min;//account for min val from whole subarray 
                max=(a[r]>max)?a[r]:max;//account for max val from whole subarray 
                break;
            }

            // if R half sorted
            if(a[m]<=a[r]){
                min=(a[m]<min)?a[m]:min; //account for min val from R half 
                max=(a[r]>max)?a[r]:max; //account for max val from R half 
                r=m-1;//restrict search space to L half only, from now
            }
            else if(a[l]<=a[m]){
                min=(a[l]<min)?a[l]:min; //account for min val from L half 
                max=(a[m]>max)?a[m]:max; //account for max val from L half 
                l=m+1;//restrict search space to R half only, from now
            }
        }
        return new int[]{min,max};
    }
}

// //lc submission
// class Solution {
//     public int findMin(int[] a) {
//         int l=0; int r=a.length-1; int min=Integer.MAX_VALUE; //int max=Integer.MIN_VALUE;
//         while(l<=r){
//             int m= l+(r-l)/2;
//             if(a[l]<=a[r]) // == (a[l]<=a[m]<=a[r]), when whole subarray is sorted
//             {
//                 min=(a[l]<min)?a[l]:min;//account for min val from whole subarray 
//                 break;
//             }

//             // if R half sorted
//             if(a[m]<=a[r]){
//                 min=(a[m]<min)?a[m]:min; //account for min val from R half 
//                 r=m-1;//restrict search space to L half only, from now
//             }
//             else if(a[l]<=a[m]){
//                 min=(a[l]<min)?a[l]:min; //account for min val from L half 
//                 l=m+1;//restrict search space to R half only, from now
//             }
//         }
//         return min;
        
//     }
// }