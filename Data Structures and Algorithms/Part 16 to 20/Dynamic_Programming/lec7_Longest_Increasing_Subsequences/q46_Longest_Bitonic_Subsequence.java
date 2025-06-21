package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

public class q46_Longest_Bitonic_Subsequence {
    //Seems right, but gibs wrong
    public static int LongestBitonicSequence_(int n, int[] a) {
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        int maxL=0;//1; 
        //cuz in q. - Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence
        boolean f1=false,f2=false;
        for(int i = 0; i<n; i ++){
            dp1[i]=1; dp2[n-1-i]=1;
            for (int pindx = 0; pindx < i ; pindx++){
                if(a[pindx]<a[i] && 1+dp1[pindx]>dp1[i]){
                    dp1[i]=1+dp1[pindx];
                    f1=true;
                }
                if(a[n-1-pindx]<a[n-1-i] && 1+dp2[n-1-pindx]>dp2[n-1-i]){
                    dp2[n-1-i]=1+dp2[n-1-pindx];
                    f2=true;
                }
            }
        }
        if(!(f1 && f2)) return 0;
        for(int i = 0; i<n; i ++){
            maxL=Math.max(maxL, dp1[i]+dp2[i]-1);
        }
        //if(maxL == n|| maxL == 1) return 0;
        return maxL;
    }

    public static int LongestBitonicSequence(int n, int[] a) {
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        int maxL=0;//1; 
        //cuz in q. - Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence
        //boolean f1=false,f2=false;
        for(int i = 0; i<n; i ++){
            dp1[i]=1; dp2[n-1-i]=1;
            for (int pindx = 0; pindx < i ; pindx++){
                if(a[pindx]<a[i] && 1+dp1[pindx]>dp1[i]){
                    dp1[i]=1+dp1[pindx];
                   // f1=true;
                }
                if(a[n-1-pindx]<a[n-1-i] && 1+dp2[n-1-pindx]>dp2[n-1-i]){
                    dp2[n-1-i]=1+dp2[n-1-pindx];
                    //f2=true;
                }
            }
        }
        //if(!(f1 && f2)) return 0;
        for(int i = 0; i<n; i ++){
            if (dp1[i] > 1 && dp2[i] > 1) { 
                // Must have both increasing and decreasing parts - vvImp
                maxL = Math.max(maxL, dp1[i] + dp2[i] - 1);
            }
        }
        //if(maxL == n|| maxL == 1) return 0;
        return maxL;
    }
}

/*public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int dp1[] = new int[n]; Arrays.fill(dp1, 1);
        int dp2[] = new int[n]; Arrays.fill(dp2, 1);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j] && 1+dp1[j]>dp1[i])
                    dp1[i] = 1+dp1[j];
            }
        }
        
        if(dp1[n-1] == n) return 0;
        int maxi = 1;
        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>i; j--){
                if(nums[i]>nums[j] && 1+dp2[j]>dp2[i])
                    dp2[i] = 1+dp2[j];
                    if(dp1[i] != 1 && dp2[i] != 1)
                        maxi = Math.max(maxi, dp1[i]+dp2[i]);
            }
        }return maxi-1;
    } */
/*package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

public class q46_Longest_Bitonic_Subsequence {
    public static int LongestBitonicSequence(int n, int[] a) {
        int[] dp1 = new int[n]; // Longest Increasing Subsequence ending at i
        int[] dp2 = new int[n]; // Longest Decreasing Subsequence starting at i
        
        // Initialize DP arrays
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            dp2[i] = 1;
        }

        // Step 1: Calculate dp1 (LIS ending at i)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        // Step 2: Calculate dp2 (LDS starting at i)
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        // Step 3: Calculate the maximum length of Bitonic Sequence
        int maxL = 0;
        for (int i = 0; i < n; i++) {
            // Subtract 1 because the current element is counted twice
            maxL = Math.max(maxL, dp1[i] + dp2[i] - 1);
        }

        // Step 4: Check for strictly increasing or decreasing sequences
        if (maxL == n || maxL == 1) return 0; // No valid bitonic sequence

        return maxL;
    }
}
 */
/*public static int LongestBitonicSequence(int n, int[] a) {
        int[] dp1 = new int[n]; // Length of LIS ending at index `i`
        int[] dp2 = new int[n]; // Length of LDS starting at index `i`
        int maxL = 0;

        // Initialize dp arrays with 1
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            dp2[i] = 1;
        }

        // Step 1: Compute LIS (dp1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp1[i] < 1 + dp1[j]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }

        // Step 2: Compute LDS (dp2)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i] && dp2[i] < 1 + dp2[j]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }

        // Step 3: Calculate maximum bitonic length
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) { // Must have both increasing and decreasing parts
                maxL = Math.max(maxL, dp1[i] + dp2[i] - 1);
            }
        }

        // If no valid bitonic sequence exists, return 0
        return maxL > 1 ? maxL : 0;
    } */