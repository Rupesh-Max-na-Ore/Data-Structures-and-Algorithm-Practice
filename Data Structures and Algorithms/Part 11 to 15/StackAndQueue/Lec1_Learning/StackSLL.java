package StackAndQueue.Lec1_Learning;
/*Q5 Stack using SLL */
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class StackSLL {
    private Node top;

    // Constructor to initialize the stack
    public StackSLL() {
        this.top = null;
    }

    // Push method to add an element to the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop method to remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // Indicates the stack is empty
        }
        int poppedValue = top.value;
        top = top.next;
        return poppedValue;
    }

    // Peek method to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1; // Indicates the stack is empty
        }
        return top.value;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackSLL stack = new StackSLL();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek()); // should print 30

        System.out.println("Popped element is: " + stack.pop()); // should print 30
        System.out.println("Popped element is: " + stack.pop()); // should print 20
        System.out.println("Popped element is: " + stack.pop()); // should print 10

        System.out.println("Stack empty: " + stack.isEmpty()); // should print true

        stack.pop(); // should print "Stack is empty. Cannot pop"
    }
}
/*//GFG submission
class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        // Add your code here
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        // Add your code here
        if(top==null) return -1;
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }
}
 */