package StackAndQueue.Lec2_Prefix_Infix_PostFix_Conversion;
/*Q5 */
import java.util.Stack;

public class PostfixToInfix {
    static String postfixToInfix(String exp) {
        Stack<String> st = new Stack<>();

        // Convert the exprsn to a char array
        char[] chars = exp.toCharArray();

        // Read the postfix exprsn from left to right
        for (char c : chars) {
            // If the c is an operator
            if (isOperator(c)) {
                // Pop two oprnds from st
                String oprnd1 = st.pop();
                String oprnd2 = st.pop();

                // Concat the oprnds and operator in infix style
                String subExpr = "(" + oprnd2 + c + oprnd1 + ")";

                // Push the resultant sub-exprsn back to st
                st.push(subExpr);
            } else { // If the c is an oprnd
                // Push oprnd to st
                st.push(String.valueOf(c));
            }
        }

        // The only elem. of the st will be the infix exprsn
        return st.pop();
    }

    static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
            default:
                return false;
        }
    }

    // Driver method
    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";
        System.out.println("Postfix expression: " + exp);
        System.out.println("Infix expression: " + postfixToInfix(exp));
    }
}
