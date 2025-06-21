package StackAndQueue.Lec2_Prefix_Infix_PostFix_Conversion;

import java.util.Stack;

/*Q6 */
public class InfixToPrefix {
    //4th attempt, perfect O(N)
    static String infixToPrefix(String exp) {
        Stack<Character> st = new Stack<>();
        char[] CE = exp.toCharArray();
        StringBuilder sb = new StringBuilder("");

        for (int i = CE.length - 1; i >= 0; i--) {
            char c = CE[i];

            if (isOperator(c)) {
                //FIgured I can merge a bunch of situations together
                while (!st.isEmpty() && Prec(c) < Prec(st.peek())) {
                    sb.insert(0, st.pop());
                }
                st.push(c);
            } else if (c == '(') {
                while (!st.isEmpty() && st.peek() != ')') {
                    sb.insert(0, st.pop());
                }
                //Somehow, code works w/o below as well
                //WHy? I think trailing ')' being not operator causes that
                if (!st.isEmpty() && st.peek() == ')') {
                    st.pop(); // pop the ')' encountered
                }
            } else if (c == ')') {
                st.push(c);
            } else { //if c is oprnd
                sb.insert(0, c);
            }
        }

        while (!st.isEmpty() && isOperator(st.peek())) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }

    //3rd attempt, almost owrks except trailing ')', man debugging is so overwhelming
    //when it encounters a ')', it simply pushes it onto the stack and doesn't 
    //remove it later. This causes the ) to remain on the stack
    // static String infixToPrefix(String exp){
    //     Stack<Character> st = new Stack<>();
    //     char[] CE = exp.toCharArray();
    //     StringBuilder sb = new StringBuilder("");
    //     for(int i = CE.length-1; i>=0; i--){
    //         char c= CE[i];
    //         if(isOperator(c)){

    //             if(st.isEmpty())//||st.peek()==')'){
    //             {    
    //                 st.push(c);
    //                 //continue;
    //             }
    //             else if(c=='^' && st.peek()=='^'){
    //                 while(!st.isEmpty() && c=='^' && st.peek()=='^'){
    //                     sb.insert(0,st.pop());
    //                 }
    //                 st.push(c);
    //             }
    //             else if(Prec(c)>=Prec(st.peek())){
    //                 st.push(c);
    //                 //continue;
    //             }
    //             else{
    //                 while(!st.isEmpty() && Prec(c) < Prec(st.peek())){
    //                     sb.insert(0,st.pop());
    //                 }
    //                 st.push(c);
    //             }
    //         }
    //         else if(c=='('){
    //             while(!st.isEmpty() && st.peek()!=')'){
    //                 sb.insert(0,st.pop());
    //             }
    //             if(!(st.isEmpty()) && (st.peek()==')')) st.pop(); // pop the ')' encountered
    //         }
    //         else{
    //             //if c is oprnd //or ')' --> problem with this code, finaaly
    //             sb.insert(0,c);
    //         }
    //     }
    //     while(!st.isEmpty() && isOperator(st.peek())) 
    //     {
    //         sb.insert(0,st.pop());
    //     }
    //     return sb.toString();
        

    // }

    //2nd attempt, works if no brackets
    // static String infixToPrefix(String exp){
    //     Stack<String> st = new Stack<>();
    //     char[] CE = exp.toCharArray();
    //     StringBuilder sb = new StringBuilder("");
    //     for(int i = CE.length-1; i>=0; i--){
    //         char c= CE[i];
    //         if(isOperator(c)){
    //             if(st.isEmpty()||st.peek().charAt(0)==')'){
    //                 st.push(String.valueOf(c));
    //                 //continue;
    //             }

    //             else if(Prec(c)>=Prec(st.peek().charAt(0))){
    //                 st.push(String.valueOf(c));
    //                 //continue;
    //             }
    //             else{
    //                 while(!st.isEmpty() && Prec(c) < Prec(st.peek().charAt(0))){
    //                     sb.append(st.pop());
    //                 }
    //                 st.push(String.valueOf(c));
    //             }
    //         }
    //         else if(c=='('){
    //             while(!st.isEmpty() && st.peek().charAt(0)!=')'){
    //                 sb.append(st.pop());
    //             }
    //         }
    //         else{
    //             //if c is oprnd or ')'
    //             sb.append(c);
    //         }
    //     }
    //     while(!st.isEmpty()) sb.append(st.pop());
    //     return sb.reverse().toString();
        

    // }
    
    static int Prec(char ch) {
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

    //1st attempt, wrong, learnt a lot tho
    // static String infixToPrefix(String exp){
    //     Stack<String> st = new Stack<>();
    //     char[] chars = exp.toCharArray();
    //     //r to l
    //     for(int i= chars.length-1; i>=0; i--){
    //         char c = chars[i];
    //         if(isOperator(String.valueOf(c))){
    //             //if(stack.pe)
    //             st.push(String.valueOf(c));
    //         }
    //         else{
    //             if(!st.isEmpty() && isOperator(st.peek())){
    //                 //c is oprnd1
    //                 String operator = st.pop();
    //                 String oprnd2 = st.pop();
    //                 String sub = operator + c + oprnd2;
    //                 st.push(sub);
    //             }else{
    //                 st.push(String.valueOf(c));
    //             }
    //         }
    //     } return st.pop();
    // }
    // static boolean isOperator(String c) {
    //     switch (c) {
    //         case "+":
    //         case "-":
    //         case "*":
    //         case "/":
    //         case "^":
    //             return true;
    //         default:
    //             return false;
    //     }
    // }

    public static void main(String[] args) {
        String exp1 = "(A-B/C)*(A/K-L)";
        System.out.println("Infix expression: " + exp1);
        System.out.println("Prefix expression: " + infixToPrefix(exp1));
        //String exp = "A-B/C";//*A/K-L";
        //String exp = "A-B/C*A/K-L";
        String exp = "x+y*z/w+u";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPrefix(exp));

        String exp2 = "(y^(f*e^x))";

        System.out.println("Infix expression: " + exp2);
        System.out.println("Prefix expression: " + infixToPrefix(exp2));
    }
}
/*
// AI code for reference, too many unnecessary ops imo, O(5n)
StackAndQueue.Lec2_Prefix_Infix_PostFix_Conversion;

import java.util.Stack;

public class InfixToPrefix {
    
    // Method to convert an infix expression to prefix
    static String infixToPrefix(String exp) {
        // Reverse the infix expression
        String reversedInfix = new StringBuilder(exp).reverse().toString();
        
        // Replace '(' with ')' and vice versa
        char[] chars = reversedInfix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
        
        // Get the postfix expression of the modified infix expression
        String postfix = infixToPostfix(new String(chars));
        
        // Reverse the postfix expression to get the prefix expression
        return new StringBuilder(postfix).reverse().toString();
    }

    // Method to convert an infix expression to postfix
    static String infixToPostfix(String exp) {
        // Initializing empty string for result
        String result = new String("");

        // Initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            // If the scanned character is '(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is ')', pop and output from the stack until '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else { // an operator is encountered
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }

        return result;
    }

    // Method to return precedence of operators
    static int Prec(char ch) {
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

    // Driver method
    public static void main(String[] args) {
        String exp = "(A-B/C)*(A/K-L)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPrefix(exp));
    }
}
 */
/*//From TUF site
Approach:
First, reverse the infix expression given in the problem.
Scan the expression from left to right.
Whenever the operands arrive, print them.

If the operator arrives and the stack is found to be empty, 
then simply push the operator into the stack.

If the incoming operator has higher precedence than the TOP 
of the stack, push the incoming operator into the stack.

If the incoming operator has the same precedence with a TOP 
of the stack, push the incoming operator into the stack.

If the incoming operator has lower precedence than the TOP of 
the stack, pop, and print the top of the stack. 
Test the incoming operator against the top of the stack again and 
pop the operator from the stack till it finds the operator 
of lower precedence or same precedence.

If the incoming operator has the same precedence with the top of 
the stack and the incoming operator is ^, then pop the top of the 
stack till the condition is true. If the condition is not true, 
push the ^ operator.

When we reach the end of the expression, pop, and print all the 
operators from the top of the stack.

If the operator is ')', then push it into the stack.
If the operator is '(', then pop all the operators from the stack 
till it finds the ‘)’ bracket in the stack.

If the top of the stack is ')', push the operator on the stack.
In the end, reverse the output. And print it.
 */