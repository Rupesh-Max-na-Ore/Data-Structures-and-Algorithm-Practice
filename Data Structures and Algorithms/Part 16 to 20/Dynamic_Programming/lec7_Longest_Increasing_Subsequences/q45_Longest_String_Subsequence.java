package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class q45_Longest_String_Subsequence {
    public int longestStrChain(String[] words) {
        int n = words.length;
        //if (n == 0) return 0; 
        // Sort array based on string length
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int[] dp = new int[n];
        //int[] parent = new int[n];
        Arrays.fill(dp, 1);
        //Arrays.fill(parent, -1);
        
        int maxI = 0; int maxL = 1;
        
            for(int i = 1; i<n; i ++){
                for (int pindx = 0; pindx < i ; pindx++){
                    if(checkPossible(words[i],words[pindx]) && 1+dp[pindx]>dp[i]){
                                            // update dp[i] & parent[i] for current elem words[i]
                                            dp[i]=1+dp[pindx];
                                            //parent[i]=pindx;
                                            
                                        }
                                    }
                                    //Update maxL & maxI considering for current elem words[i]
                                    if(maxL<dp[i]){
                                        maxL=dp[i];
                                        maxI=i;
                                    } 
                                }
                                return maxL;
                                // //s4 print
                                // LinkedList<String> list = new LinkedList<>();
                                // int j=maxI;
                                // while(j!=-1){
                                //     list.addFirst((String)words[j]);
                                //     j=parent[j];
                                // }
                                // return list;
                    
                        }
                    
                        private boolean checkPossible(String s1, String s2) {
                            if (s1.length() != s2.length() + 1) {
                                return false;
                            }
                    
                            int p1 = 0;
                            int p2 = 0;
                    
                            while (p1 < s1.length()) {
                                if (p2 < s2.length() && s1.charAt(p1) == s2.charAt(p2)) {
                                    p1++;
                                    p2++;
                                } else {
                                    p1++;
                                    if(p1>(p2+1)) return false;
                                }
                            }
                    
                            return (p1 == s1.length() && p2 == s2.length());
                        }
                    
                        
}
/*import java.util.Arrays;
import java.util.Comparator;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}

public class SortByLengthCustomComparator {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "kiwi", "cherry"};

        Arrays.sort(arr, new StringLengthComparator());

        System.out.println(Arrays.toString(arr));
    }
}
 */