package Recursion_Pattern_Wise;
/*Q4 Sort a stack
MediumAccuracy: 69.19%Submissions: 111K+Points: 4
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
1<=N<=100

 */
import java.util.Stack;

public class SortAStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (s.isEmpty()||s.size()==1) return s; // Base case
        int var = s.pop();
        sort(s); // Inductive Hypothesis: smaller stack is sorted
        sortedInsert(s, var); // Inductive Step: way to insert a var in correct place in stack 
        return s;
    }
    private void sortedInsert(Stack<Integer> s, int var) {
        if (s.isEmpty() || s.peek() <= var) {
            //Base case
            s.push(var);
            return;
        }
        //Hypothesis: will insertion of var in smaller stack, so remove top  
        //cuz top is bigger than var, var correct pos is deeper in stack, so keep popping
        int top = s.pop(); 
        sortedInsert(s, var);
        // Inductive Step: way to insert top(that was removed to make stack smaller for Hypothesis step) 
        // back in correct place in stack
        s.push(top); 
    }

    // First attempt, wrong
    //     public Stack<Integer> sort(Stack<Integer> s) {
    //         if(s.size()==1) return s;
    //         int var=s.pop();
    //         sort(s);
    //         if(s.peek()>var){
    //             int top=s.pop();
    //             s.push(var);
    //             s.push(top);
    //         } else s.push(var);
    //         return s;
    // }

    public static void main(String[] args) {
        SortAStack solution = new SortAStack();
        
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        Stack<Integer> sortedStack1 = solution.sort(stack1);
        System.out.println("Sorted Stack 1: " + sortedStack1); // Output: [3, 2, 1]

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(11);
        stack2.push(2);
        stack2.push(32);
        stack2.push(3);
        stack2.push(41);
        Stack<Integer> sortedStack2 = solution.sort(stack2);
        System.out.println("Sorted Stack 2: " + sortedStack2); // Output: [41, 32, 11, 3, 2]
    }

}
