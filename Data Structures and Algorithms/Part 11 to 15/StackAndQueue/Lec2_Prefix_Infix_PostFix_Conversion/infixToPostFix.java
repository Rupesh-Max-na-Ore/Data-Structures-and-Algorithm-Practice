package StackAndQueue.Lec2_Prefix_Infix_PostFix_Conversion;
import java.util.Stack;
/*Q1 Infix to Postfix 
Problem Statement: Given an infix expression, Your task is to convert the given infix expression to a postfix expression.

Examples:

Example 1:
Input: a+b*(c^d-e)^(f+g*h)-i
Output: abcd^e-fgh*+^*+i-
Explanation: Infix to postfix

Example 2:
Input: (p+q)*(m-n)
Output: pq+mn-*
Explanation: Infix to postfix
*/
public class infixToPostFix {
    // all the sopln statemnts sre for debugging
    static String infixToPostfix(String exp) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder sbAns = new StringBuilder();
    
        // Stack for operators
        Stack<Character> stack = new Stack<>();
        char[] ch = exp.toCharArray();
        for (char c: ch) {    
            // If c is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                //System.out.println("before:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                sbAns.append(c);
                //System.out.println("after:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
            }
            // If c is '(', push it to the stack
            else if (c == '(') {
                //System.out.println("before:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                stack.push(c);
                //System.out.println("after:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
            }
            // If c is ')', pop and output from the stack
            // until an '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    //System.out.println("before:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                    sbAns.append(stack.pop());
                    //System.out.println("after:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                }
                stack.pop(); // Remove '(' from the stack
            }
            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    //System.out.println("before:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                    sbAns.append(stack.pop());
                    //System.out.println("after:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                }
                //System.out.println("before:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);
                stack.push(c);
                //System.out.println("after:     "+c+"   "+((!stack.isEmpty())?stack.peek():"-")+"   "+sbAns);

            }
        }
    
        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Mismatched parentheses
            }
            sbAns.append(stack.pop());
        }
        return sbAns.toString();
    }
    
    // Method to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    // Driver method - main () is aka driver method
    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Postfix expression: " + infixToPostfix(exp));
    }
}
/*//FOund a even better reference code, more readable and faster due to switch case
static String infixToPostfix(String exp) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();
    
        // Stack for operators
        Stack<Character> stack = new Stack<>();
    
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
    
            switch (c) {
                // If the scanned character is an operand, add it to output
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(c);
                    break;
    
                // If the scanned character is '('
                case '(':
                    stack.push(c);
                    break;
    
                // If the scanned character is ')'
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop(); // Remove '(' from the stack
                    break;
    
                default: // If the scanned character is an operand
                    if (Character.isLetterOrDigit(c)) {
                        result.append(c);
                    }
                    break;
            }
        }
    
        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Mismatched parentheses
            }
            result.append(stack.pop());
        }
        return result.toString();
    }
    
    // Method to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
 */