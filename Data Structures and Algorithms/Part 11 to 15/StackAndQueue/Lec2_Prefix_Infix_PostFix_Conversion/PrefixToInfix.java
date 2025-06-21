package StackAndQueue.Lec2_Prefix_Infix_PostFix_Conversion;
/*Q2 */
import java.util.Stack;

public class PrefixToInfix {
    static String prefixToInfix(String exp) {
        Stack<String> st = new Stack<>();
        char[] CE = exp.toCharArray();
        // Read the prefix exprsn in reverse order
        for (int i = (CE.length - 1); i >= 0; i--) {
            char c = CE[i];
    
            // If the c is an operator
            if (isOperator(c)) {
                // Pop two oprnds from st
                String oprnd1 = st.pop();
                String oprnd2 = st.pop();
    
                // Concat the oprnds and operator in infix style
                //String subExpr = "(" + oprnd1 + c + oprnd2 + ")"; // Still faster cuz short
                StringBuilder subExpr = new StringBuilder("(");
                subExpr.append(oprnd1);
                subExpr.append(c);
                subExpr.append(oprnd2);
                subExpr.append(')');
                // Push the resultant sub-exprsn back to st
                //st.push(subExpr);
                st.push(subExpr.toString());

            } else { // If the c is an oprnd
                // Push oprnd to st
                //st.push((String)(c-'0'));
                st.push(String.valueOf(c));
            }
        }
    
        // The only elem. of the st will be the infix exprsn
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
        System.out.println("Infix expression: " + prefixToInfix(exp));
    }
}
