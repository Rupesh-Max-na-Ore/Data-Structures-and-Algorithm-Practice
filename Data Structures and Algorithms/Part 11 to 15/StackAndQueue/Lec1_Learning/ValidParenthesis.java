package StackAndQueue.Lec1_Learning;
import java.util.Stack;
/*Q7 20. Valid Parentheses
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
4.7M
Submissions
11.6M
Acceptance Rate
40.7% */
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        char[] ch = s.toCharArray();
        for (char c: ch) {
            if (c == '(' || c == '[' || c == '{')
                st.push(c);
            else {
                if(st.isEmpty()) return false;
                char top = st.pop(); 
                if((c == ')' && top != '(') ||  (c == ']' && top != '[') || (c == '}' && top != '{')) return false;
            }
        }
        return st.isEmpty();
    }
}
/*Time complexity: O(n) where n = length of string.
Space complexity: O(n) */
/*//clean HM soln
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> complement = 
            new HashMap<Character, Character>();

        complement.put(')', '(');
        complement.put(']', '[');
        complement.put('}', '{');

        for (Character c : s.toCharArray()) {
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty() || stack.pop() != complement.get(c)) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
    // another way to write cleanly, switch case
    class Solution {
    public boolean isValid(String s) {


        // Create a new stack to store the characters.
        Stack<Character> stack = new Stack<>();


        // convert string into char array and access the characters using for each loop.
        for(char ch: s.toCharArray())
        {
            // check ch
            switch (ch)
            {
                // open bracket then push it in stack.
                // close bracket then pop the item and compare.
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')

                    // if the stack is empty then it means string have no open bracket.
                        // hence it is invalid.
                    {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                    {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                    {
                        return false;
                    }
                    break;
            }
        }


        // After the loop we have to check one more condition.
        // return true only if the stack is empty.
        // if stack is not empty that means we have unused brackets.

        return stack.isEmpty();
        
    }
}
//From - https://leetcode.com/problems/valid-parentheses/solutions/2986468/simple-java-beats-100-runtime-easy-to-understand/ */