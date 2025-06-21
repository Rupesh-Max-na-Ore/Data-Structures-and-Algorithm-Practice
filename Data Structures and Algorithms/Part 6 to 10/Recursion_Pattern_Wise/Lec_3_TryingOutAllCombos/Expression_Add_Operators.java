package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;

import java.util.ArrayList;
import java.util.List;

/*Q8 282. Expression Add Operators
Hard
Topics
Companies
Hint
Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1
Seen this question in a real interview before?
1/5
Yes
No
Accepted
227.2K
Submissions
568.5K
Acceptance Rate
40.0% */
public class Expression_Add_Operators {
    public List<String> addOperators(String num, int target) {
        List<String> exprsns = new ArrayList<>();
        if (num == null || num.length()==0) return exprsns;
        addOperators(num, target, 0, 0, 0, "", exprsns);
        return exprsns;
    }

    private void addOperators(String s, int k, int index, long currVal, long lastVal, String exprsn, List<String> Ans) {
        //Base
        if (index == s.length()) {
            if (currVal == k) Ans.add(exprsn);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // Avoid 2nd operad as nos. with leading zero, except '0' alone itself
            if (i != index && s.charAt(index) == '0') break; 
            // can break, as loop run once, next recursive calls take care such that it doesn't stop soln. generation
            long currDigitsVal = Long.parseLong(s.substring(index, i + 1));
            if (index == 0) {
                // if currently at 1st digit only, then don't apply any operator
                addOperators(s, k, i + 1, currDigitsVal, currDigitsVal, exprsn + currDigitsVal, Ans);
            } else {
                // 3  calls with ops. 
                addOperators(s, k, i + 1, currVal + currDigitsVal, currDigitsVal, exprsn + "+" + currDigitsVal, Ans);
                addOperators(s, k, i + 1, currVal - currDigitsVal, -currDigitsVal, exprsn + "-" + currDigitsVal, Ans);
                addOperators(s, k, i + 1, currVal - lastVal + lastVal * currDigitsVal, lastVal * currDigitsVal, exprsn + "*" + currDigitsVal, Ans);
            }
        }
    }
}
/*
// soln on lc forum, that just uses char[] to speed up operations
void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
    if (pos == digits.length) {
        if (left + cur == target) ret.add(new String(path, 0, len));
        return;
    }
    long n = 0;
    int j = len + 1;
    for (int i = pos; i < digits.length; i++) {
        n = n * 10 + digits[i] - '0';
        path[j++] = digits[i];
        path[len] = '+';
        dfs(ret, path, j, left + cur, n, digits, i + 1, target);
        path[len] = '-';
        dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
        path[len] = '*';
        dfs(ret, path, j, left, cur * n, digits, i + 1, target);
        if (digits[pos] == '0') break; 
    }
}
public List<String> addOperators(String num, int target) {
    List<String> ret = new LinkedList<>();
    if (num.length() == 0) return ret;
    char[] path = new char[num.length() * 2 - 1];
    char[] digits = num.toCharArray();
    long n = 0;
    for (int i = 0; i < digits.length; i++) {
        n = n * 10 + digits[i] - '0';
        path[i] = digits[i];
        dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
        if (n == 0) break;
    }
    return ret;
}
    //https://leetcode.com/problems/expression-add-operators/solutions/71897/java-ac-solution-19ms-beat-100-00/
 */