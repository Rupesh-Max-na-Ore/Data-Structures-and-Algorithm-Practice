package StackAndQueue.Lec1_Learning;
/*Q8 155. Min Stack
Solved
Medium
Topics
Companies
Hint
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.7M
Submissions
3.1M
Acceptance Rate
54.4%*/
import java.util.Stack;

public class MinStackConstantTime {
    //Way 3 - refer notes for intuition
    Stack <Long> st = new Stack <Long> ();
    Long Min=Long.MAX_VALUE;

    // No need for explicit constructor, java makes default constructor that does nothing automaticcalyy
    // public MinStack() {
    // }

    public void push(int v) {
        Long val = Long.valueOf(v);
        if (st.isEmpty()) {
            Min = val;
            st.push(val);
        } 
        else if (val < Min) {
            st.push(2*val - Min);
            Min = val;
        } 
        else st.push(val);
        
    }

    public void pop() {
        if (st.isEmpty()) return;

        Long val = st.pop();
        if (val < Min) Min = 2*Min - val;
    }

    public int top() {
        Long val = st.peek();
        if (val < Min) return Min.intValue();
        return val.intValue();
    }

    public int getMin() {
        return Min.intValue();
    }
}
/*//LC submission with way 1
class MinStack {
    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    private Node top;
    //No need  for constructor here, still can use;
    public MinStack() {
        this.top=null;
    }
    
    public void push(int val) {
        if(top==null) top = new Node(val, val, null);//1st node
        else top = new Node(val, Math.min(val, top.min), top);
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// */