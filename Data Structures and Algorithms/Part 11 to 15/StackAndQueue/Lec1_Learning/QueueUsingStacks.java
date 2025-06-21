package StackAndQueue.Lec1_Learning;
/*Q3 Queue Using 2 Stack */
/*
// LC submission 1 - 2 stacks soln.
class MyQueue {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int v = s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return v;
    }
    
    public int peek() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int v = s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return v;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
    
// LC submission 2 - Recursive 1 stack soln.
class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int pop = stack.pop();
        push(x);
        stack.push(pop);
    }

    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// */

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation to remove the front element from the queue
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue");
                return -1; // Indicates the queue is empty
            }
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation to return the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty. Cannot peek");
                return -1; // Indicates the queue is empty
            }
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element is: " + queue.peek()); // should print 10

        System.out.println("Dequeued element is: " + queue.dequeue()); // should print 10
        System.out.println("Dequeued element is: " + queue.dequeue()); // should print 20
        System.out.println("Dequeued element is: " + queue.dequeue()); // should print 30

        System.out.println("Queue empty: " + queue.isEmpty()); // should print true

        queue.dequeue(); // should print "Queue is empty. Cannot dequeue"
    }
}
