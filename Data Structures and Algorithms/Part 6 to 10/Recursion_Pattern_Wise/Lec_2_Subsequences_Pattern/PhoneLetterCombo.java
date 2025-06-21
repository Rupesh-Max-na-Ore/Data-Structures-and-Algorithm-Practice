package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.LinkedList;
import java.util.List;

/*Q12 17. Letter Combinations of a Phone Number
Medium
Topics
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2.1M
Submissions
3.4M
Acceptance Rate
60.7% */
public class PhoneLetterCombo {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        int n=digits.length();
        if(digits == null || digits.length() == 0) return ans;
        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        recurBuild(digits,n,ans,map,new StringBuilder(),0);
        return ans;
    }

    private void recurBuild(String s, int n, List<String> ans, char[][] map, StringBuilder sb, int i) {
        //if(i==n){ // giving wrong answer, stack overflow or array out of bounds, relates to referencing
        if(i==s.length()){
            ans.add(new String(sb));
            return;
        }
        //char to digit conversion 
        int num = s.charAt(i)-'0';
        //iterate thru all chars associated with the no.
        for(int j=0;j<map[num].length;j++){
            //consider jth char mapped to ith num in digits
            sb.append(map[num][j]); //add
            recurBuild(s, num, ans, map, sb, i+1);
            sb.deleteCharAt(sb.length()-1); //backtrack by deleting last char
        }
    }
    
}
/*//another soln., for later revision
My java solution with FIFO queue

lirensun
1254
235201
Feb 06, 2015
public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
A version without first loop, but same time complexity. Both are single queue BFS solutions.:

public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
 */