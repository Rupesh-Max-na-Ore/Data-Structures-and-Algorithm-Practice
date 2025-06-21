package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class q44_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] a) {
        //1Arr Way, Intuitive-ish
            int n=a.length;
            Arrays.sort(a);//s1
            //s2 ini.
            int dp[]=new int[n];
            for(int i = 0; i<n; i ++) dp[i]=1;
    
            int maxL=1;
            int maxI=0;
            int parent[]=new int[n];
            for(int i = 0; i<n; i ++) parent[i]=-1;

            //s3 populate dp[] & parent[]
            for(int i = 1; i<n; i ++){
                for (int pindx = 0; pindx < i ; pindx++){
                    if((a[i]%a[pindx]==0) && 1+dp[pindx]>dp[i]){
                        // update dp[i] & parent[i] for current elem a[i]
                        dp[i]=1+dp[pindx];
                        parent[i]=pindx;
                        
                    }
                }
                //Update maxL & maxI considering for current elem a[i]
                if(maxL<dp[i]){
                    maxL=dp[i];
                    maxI=i;
                } 
            }
    
            //s4 print
            LinkedList<Integer> list = new LinkedList<>();
            int j=maxI;
            while(j!=-1){
                list.addFirst((Integer)a[j]);
                j=parent[j];
            }
            return list;
    }
}
/*


//Nice commented AI code
package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q44_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n = a.length;
        if (n == 0) return new ArrayList<>(); // Handle edge case
        
        // Step 1: Sort the array
        Arrays.sort(a);

        // Step 2: Initialize dp and parent arrays
        int[] dp = new int[n]; // Length of the LDS ending at each index
        int[] parent = new int[n]; // To track previous element indices
        Arrays.fill(dp, 1); // Each element is a subset of length 1
        Arrays.fill(parent, -1); // -1 indicates no parent

        int maxL = 1; // Maximum length of LDS
        int maxI = 0; // Index of the last element in the LDS

        // Step 3: Populate dp and parent arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] % a[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxL) {
                maxL = dp[i];
                maxI = i;
            }
        }

        // Step 4: Reconstruct the LDS
        List<Integer> result = new ArrayList<>();
        while (maxI != -1) {
            result.add(a[maxI]);
            maxI = parent[maxI];
        }

        // Reverse the list to get the correct order
        Collections.reverse(result);
        return result;
    }
}
 */