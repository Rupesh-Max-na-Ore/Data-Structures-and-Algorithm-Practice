package Recursion_Pattern_Wise;
/*Q5  Reverse a Stack
MediumAccuracy: 80.5%Submissions: 71K+Points: 4
You are given a stack St. You have to reverse the stack using recursion.

Example 1:

Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}
Explanation:
Input stack after reversing will look like the stack in the output.
Example 2:

Input:
St = {4,3,9,6}
Output:
{6,9,3,4}
Explanation:
Input stack after reversing will look like the stack in the output.
Your Task:

You don't need to read input or print anything. Your task is to complete the function Reverse() which takes the stack St as input and reverses the given stack.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= size of the stack <= 104
-109 <= Each element of the stack <= 109
Sum of N over all test cases doesn't exceeds 106
Array may contain duplicate elements. 

*/
import java.util.Stack;

public class ReverseAStack {
    static void reverse(Stack<Integer> s)
    {
        if(s.size()==1) return;
        int var = s.pop();
        reverse(s);
        insert(s,var);
        return;
    }

    private static void insert(Stack<Integer> s, int var) {
        if(s.isEmpty()) {
            s.push(var); 
            return;
        }
        int top=s.pop();
        insert(s, var);
        s.push(top);
        return;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        stack1.push(7);
        stack1.push(6);

        System.out.println("Original Stack: " + stack1);
        reverse(stack1);
        System.out.println("Reversed Stack: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(4);
        stack2.push(3);
        stack2.push(9);
        stack2.push(6);

        System.out.println("Original Stack: " + stack2);
        reverse(stack2);
        System.out.println("Reversed Stack: " + stack2);
    }
}
