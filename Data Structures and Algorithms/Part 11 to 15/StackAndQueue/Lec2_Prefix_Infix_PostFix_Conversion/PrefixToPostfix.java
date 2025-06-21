package StackAndQueue.Lec2_Prefix_Infix_PostFix_Conversion;
/*Q3 */
import java.util.Stack;

public class PrefixToPostfix {
    static String prefixToPostfix(String exp) {
        Stack<String> st = new Stack<>();
    
        char[] CE = exp.toCharArray();
        // Read the postfix exprsn in reverse order
        for (int i = (CE.length - 1); i >= 0; i--) {
            char c = CE[i];
    
            // If the c is an operator
            if (isOperator(c)) {
                // Pop two oprnds from st
                String oprnd1 = st.pop();
                String oprnd2 = st.pop();
    
                // Concat the oprnds and operator in postfix style
                String subExpr = oprnd1 + oprnd2 + c;
    
                // Push the resultant sub-exprsn back to st
                st.push(subExpr);
            } else { // If the c is an oprnd
                // Push oprnd to st
                st.push(String.valueOf(c));
                //st.push((String)(c-'0'));
            }
        }
    
        // The only elem. of the st will be the postfix exprsn
        return st.pop();
    }
    
    static boolean isOperator(char c) {
        //always better to use switch case instead of if-else when possible, but too lazy rn
        return ((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '^'));
    }
    
    // Driver method - main () is aka driver method
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Prefix expression: " + exp);
        System.out.println("Postfix expression: " + prefixToPostfix(exp));
    }
}
