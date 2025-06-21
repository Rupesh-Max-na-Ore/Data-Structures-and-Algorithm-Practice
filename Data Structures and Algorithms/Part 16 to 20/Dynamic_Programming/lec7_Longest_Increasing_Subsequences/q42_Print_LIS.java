package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

import java.util.ArrayList;
import java.util.LinkedList;

public class q42_Print_LIS {
        //1Arr Way, Intuitive-ish
        public int lengthOfLIS(int[] a) {
            int n=a.length;
            int dp[]=new int[n];
            for(int i = 0; i<n; i ++) dp[i]=1;
    
            int maxNo=Integer.MIN_VALUE;
            int maxI=-1;
            int parent[]=new int[n];
            for(int i = 0; i<n; i ++) parent[i]=-1;
            for(int i = 0; i<n; i ++){
                for (int pindx = i-1; pindx >=0; pindx--){
                    if(a[pindx]<a[i] && 1+dp[pindx]>dp[i]){
                        dp[i]=1+dp[pindx];
                        parent[i]=pindx;
                        if(maxNo<dp[i]){
                            maxNo=dp[i];
                            maxI=i;
                        }
                    }
                } 
            }
    
            //print
            LinkedList<Integer> list = new LinkedList<>();
            int j=maxI;
            while(j!=-1){
                list.addFirst((Integer)a[j]);
                j=parent[j];
            }
            return new ArrayList<Integer>(list);
            //return (maxI!=-1)?dp[maxI]:1;
        }

        public ArrayList<Integer> longestIncreasingSubsequence(int n, int a[]) {
                    //int n=a.length;
                    int dp[]=new int[n];
                    for(int i = 0; i<n; i ++) dp[i]=1;
            
                    int maxNo=Integer.MIN_VALUE;
                    int maxI=-1;
                    int parent[]=new int[n];
                    for(int i = 0; i<n; i ++) parent[i]=-1;
                    for(int i = 0; i<n; i ++){
                        for (int pindx = i-1; pindx >=0; pindx--){
                            if(a[pindx]<a[i] && 1+dp[pindx]>dp[i]){
                                dp[i]=1+dp[pindx];
                                parent[i]=pindx;
                                }
                            }
                            if(maxNo<dp[i]){
                                maxNo=dp[i];
                                maxI=i;
                            
                        } 
                    }
            
                    //print
                    LinkedList<Integer> list = new LinkedList<>();
                    int j=maxI;
                    while(j!=-1){
                        list.addFirst((Integer)a[j]);
                        j=parent[j];
                    }
                    return new ArrayList<Integer>(list);
                    //return (maxI!=-1)?dp[maxI]:1;
        
                }
    
}
/*GFG submission - was only taking 1st LIS encountered as O/P rather than all
            public ArrayList<Integer> longestIncreasingSubsequence(int n, int a[]) {
                    //int n=a.length;
                    int dp[]=new int[n];
                    for(int i = 0; i<n; i ++) dp[i]=1;
            
                    int maxNo=Integer.MIN_VALUE;
                    int maxI=0;
                    int parent[]=new int[n];
                    for(int i = 0; i<n; i ++) parent[i]=-1;
                    // Populate dp[] and parent[]
                    for (int i = 0; i < n; i++) {
                        for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                            if (a[prevIndex] < a[i] && dp[prevIndex] + 1 > dp[i]) {
                                dp[i] = dp[prevIndex] + 1;
                                parent[i] = prevIndex;
                            }
                        }
                        // Update the max. LIS length and its ending index
                        if (dp[i] > maxNo) {
                            maxNo = dp[i];
                            maxI = i;
                        }
                    }
                    //print
                    LinkedList<Integer> list = new LinkedList<>();
                    int j=maxI;
                    while(j!=-1){
                        list.addFirst((Integer)a[j]);
                        j=parent[j];
                    }
                    return new ArrayList<Integer>(list);
                    //return (maxI!=-1)?dp[maxI]:1;
        
                }

 */