package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

//Q4 gfg
/*Better String
HardAccuracy: 44.5%Submissions: 46K+Points: 8
Given a pair of strings of equal lengths, Geek wants to find the better string. The better string is the string having more number of distinct subsequences.
If both the strings have equal count of distinct subsequence then return str1.

Example 1:

Input:
str1 = "gfg", str2 = "ggg"
Output: "gfg"
Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct subsequences. 
Example 2:

Input: str1 = "a", str2 = "b"
Output: "a"
Explanation: Both the strings have only 1 distinct subsequence. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function betterString() which takes str1 and str2 as input parameters and returns the better string.

Expected Time Complexity: O( N ), where N is the length of both provided strings.

Expected Auxiliary Space: O( N )

Constraints:
1 <= N <= 30

 */
public class BetterStrings {
    public static String betterString(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        int a=countDistinctSubseqns(s1,n1);
        int b=countDistinctSubseqns(s2,n2);
        if(a>=b) return s1;
        return s2;

    }
    private static int countDistinctSubseqns(String s, int n) {
        Map<Character,Integer> hm=new HashMap<>();
        int[] distinctTillind=new int[n+1];
        distinctTillind[0]=1;// ini to 0 if null string not counted, or just -1 at end
        for(int i=1;i<=n;i++){
            char elem=s.charAt(i-1);
            distinctTillind[i]=2*distinctTillind[i-1];
            if(hm.containsKey(elem)) 
                distinctTillind[i]-=distinctTillind[hm.get(elem)];
            hm.put(elem, i-1);
        } 
        System.out.println("Distinct subsequences in "+s+" = " + (distinctTillind[n]-1));
        return distinctTillind[n]; // as only relative comparison matters, -1 not essential, 
        // required only if exact non-null subsequences count needed
    }
    public static void main(String[] args) {
        String str1 = "gfg";
        String str2 = "ggg";
        System.out.println(betterString(str1, str2)); // Output: "gfg"
        
        str1 = "a";
        str2 = "b";
        System.out.println(betterString(str1, str2)); // Output: "a"
    }

    // Test Cases Passed: 692 /1116 Time Limit Exceeded
    // public static String betterString(String s1, String s2) {
    //     int n1=s1.length();
    //     int n2=s2.length();
    //     HashMap<String,Integer> hm1=new HashMap<>();
    //     HashMap<String,Integer> hm2=new HashMap<>();
    //     recurSub(s1,n1,0,"",hm1);
    //     recurSub(s2,n2,0,"",hm2);
    //     if(hm1.size()>hm2.size()) return s1;
    //     return s2;
    // }

    // private static void recurSub(String s, int n, int i, String sub, HashMap<String, Integer> hm) {
    //     //basse
    //     if(i==n){
    //         if(hm.containsKey(sub)) hm.put(sub, hm.get(sub)+1);
    //         else hm.put(sub, 1);
    //         return;
    //     }
    //     //reject
    //     recurSub(s, n, i+1, sub, hm);
    //     //select
    //     recurSub(s, n, i+1, sub+s.charAt(i), hm);
    // }
 
}
