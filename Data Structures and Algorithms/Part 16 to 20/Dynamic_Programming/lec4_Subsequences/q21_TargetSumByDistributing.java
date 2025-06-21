package Dynamic_Programming.lec4_Subsequences;

public class q21_TargetSumByDistributing {
    //Same Logic as q18

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum<target || (sum-target)%2!=0){
            return 0;
        }
        int s2 = (sum - target)/2;
        return findWays(nums,(sum-target)/2);
    }

    //Cnt Subset Sum w/ sum = k
    public static int findWays(int[] a, int k){
        int n = a.length;
        int prev[] = new int[k+1];
        if(a[0] == 0) prev[0] =2;  //incl and excl
        else prev[0] = 1;  // excl
        if(a[0]!=0 && a[0]<=k) prev[a[0]] = 1;  // incl
        for(int i = 1; i<n; i++){
            int cur[]=new int[k+1];
            for(int j= 0; j<=k; j++){
                int excl = prev[j];
                int incl = (a[i]<=j)?prev[j-a[i]]:0;
                cur[j]= (excl + incl);
            }
            prev = cur;
        }
        return prev[k];
    }

}
