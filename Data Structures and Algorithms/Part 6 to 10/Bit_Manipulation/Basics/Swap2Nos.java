package Bit_Manipulation.Basics;

import java.util.ArrayList;
import java.util.List;
/*Q7 Swap two numbers
SchoolAccuracy: 70.02%Submissions: 49K+Points: 0
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Swap given two numbers and print them. (Try to do it without a temporary variable.) and return it.

Example 1:

Input: a = 13, b = 9
Output: 9 13
Explanation: after swapping it
becomes 9 and 13.
Example 2:

Input: a = 15, b = 8
Output: 8 15
Explanation: after swapping it
becomes 8 and 15.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function get() which takes a, b as inputs and returns the list of integers contains the new value of a and b after swap.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ a, b ≤ 106 */
public class Swap2Nos {
    static List<Integer> get(int a,int b)
    {
        List<Integer> ans = new ArrayList<>();
        a=a^b;
        b=a^b;//b => (a^b)^b == a
        a=a^b;//a => (a^b)^a == b
        ans.add(a);
        ans.add(b);
        return ans;
    }
}
