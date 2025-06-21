package Binary_Search.BS_on_1D_Arrays;

public class LeastUpperBound {
    // == finding ceil
    public static int LUB_Finder(int[]a, int n, int k)
    {
        int l=0; int r=n-1; int LUB=n; // Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>=k) 
            {
                LUB=m;
                r=m-1;
            }
        }
        return LUB;
    }
}
