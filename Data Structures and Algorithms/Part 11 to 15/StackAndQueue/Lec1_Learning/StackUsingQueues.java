package StackAndQueue.Lec1_Learning;
/*Q4 Stack Using 2 Queues */
/*//LC submission 1 - 2 stack iterative
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        top=x;
    }
    
    public int pop() {
        int lastPop;
        while(q1.size()>1){
            q2.add(q1.remove());
            //top = q1.remove();
            //q2.add(top);
        }
        lastPop = q1.remove();
        while(!q2.isEmpty()){
            //q1.add(q2.remove());
            top = q2.remove(); //Updating top imp. here
            q1.add(top);
        }
        // Queue<Integer> temp = q1;
        // q1 = q2;
        // q2 = temp;
        return lastPop;
    }
    
    public int top() {
        if (q1.isEmpty()) {
            return -1; 
        }
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

// LC submission 2 - 1 stack only, via rotating queue during enqueue
class MyStack {
    Queue<Integer> q1;
    int top;

    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int v) {
        q1.add(v);
        top = v;
        int size = q1.size();
        // Rotate the queue to move the newly added elem. to the front
        for (int i = 1; i < size; i++) {
            q1.add(q1.remove());
        }
        // Wrong Way, fail to see the gestalt
        // found out after dry run after pushing 3+ elems.
        // if(q1.isEmpty()){
        //     top =v;
        //     q1.add(v);
        //     return;
        // }
        // int lastPop=q1.remove();
        // push(v);
        // q1.add(lastPop);//Backtrack
    }
    
    public int pop() {
        int lastPop = q1.remove();
        if(!q1.isEmpty()) top = q1.peek();
        return lastPop;
    }
    
    public int top() {
        if (q1.isEmpty()) {
            return -1; 
        }
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//*/


import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    // Constructor to initialize the queues
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation to add an element to the stack
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    // Pop operation to remove the top element from the stack
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // Indicates the stack is empty
        }
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top); 
        }
        // The last element in q1 is the top element of the stack
        int poppedValue = q1.remove();

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedValue;
    }

    // Peek operation to return the top element without removing it
    public int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1; // Indicates the stack is empty
        }
        return top;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.top()); // should print 30

        System.out.println("Popped element is: " + stack.pop()); // should print 30
        System.out.println("Popped element is: " + stack.pop()); // should print 20
        System.out.println("Popped element is: " + stack.pop()); // should print 10

        System.out.println("Stack empty: " + stack.isEmpty()); // should print true

        stack.pop(); // should print "Stack is empty. Cannot pop"
    }
}
