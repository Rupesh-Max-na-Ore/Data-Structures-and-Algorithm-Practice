package Binary_Search.BS_on_1D_Arrays;
/*
 * Q11
 * No. of Rotations in a[]
 */

public class CountRot {

    public int countRotations(int[]a, int n){
        //== finding min. elem. index
        int l=0; int r=n-1; int min=Integer.MAX_VALUE; int minI=n;
        while(l<=r){
            int m= l+(r-l)/2;
            if(a[l]<=a[r]) // == (a[l]<=a[m]<=a[r]), when whole subarray is sorted
            {
                if(a[l]<min)//account for min val from whole subarray
                    {
                        min=a[l];
                        minI=l; 
                        return l;
                    }
            }

            // if R half sorted
            if(a[m]<=a[r]){
                if(a[m]<min) //account for min val from R half
                {
                    min=a[m];
                    minI=m;
                } 
                r=m-1;//restrict search space to L half only, from now
            }
            else if(a[l]<=a[m]){
                if(a[l]<min) //account for min val from L half
                {
                    min=a[l];
                    minI=l;
                } 
                l=m+1;//restrict search space to R half only, from now
            }
        }
        return minI;

    }
    
}
// exact same code gfg submission