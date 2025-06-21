package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.Collections;

//Q3 
/*Power Set: Print all the possible subsequences of the String

Problem Statement: Given a string, find all the possible subsequences of the string.

Examples:

Example 1:
Input: str = "abc"
Output: a ab abc ac b bc c
Explanation: Printing all the 7 subsequence for the string "abc".

Example 2:
Input: str = "aa"
Output: a a aa 
Explanation: Printing all the 3 subsequences for the string "aa" */
public class PrintAllSubsequences {
    static void recur(int i, String s, String f) {
        if (i == s.length()) {
            System.out.print(f+" ");
            return;
        }
        //selecting 
        recur(i + 1, s,  f+s.charAt(i));
        //rejecting
        recur(i + 1, s,  f);
    }
    public static void main(String args[]) {
        String s = "abc";
        String f = "";
        System.out.println("All possible subsequences are: ");
        recur(0, s, f);
        String s1="abc";
	    ArrayList<String>ans = AllPossibleStrings(s1);
	    System.out.println("All possible subsequences are = ");
	    for (String it : ans) {
		System.out.print( it+" ");
	    }
    }
    static ArrayList<String> AllPossibleStrings(String s) {
	int n = s.length();
	ArrayList<String>ans=new ArrayList<>();
	for (int num = 0; num < (1 << n); num++) {
		String sub = "";
		for (int i = 0; i < n; i++) {
			//check if the ith bit is set or not
			if ((num & (1 << i))!=0) {
				sub += s.charAt(i);
			}
		}
		if (sub.length() > 0) {
			ans.add(sub);
		}
	}
	//Collections.sort(ans);
	return ans;
}

}
