package StackAndQueue.Lec1_Learning;
/*Q1 Stack using Arrays */
// Comments were told to be added by AI
public class Stack {
    private int[] stackArray;
    private int top;
    private int maxSize;

    // Constructor to initialize stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // indicates the stack is empty
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }


    // Pop method to remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // indicates the stack is empty
        }
        return stackArray[top--];
    }

    // Peek method to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return Integer.MIN_VALUE; // indicates the stack is empty
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element is: " + stack.peek()); // should print 50

        stack.push(60); // should print "Stack is full. Cannot push 60"

        while (!stack.isEmpty()) {
            System.out.println("Popped element is: " + stack.pop());
        }

        System.out.println("Stack empty: " + stack.isEmpty()); // should print true
    }
}
/*//GFG submission
class MyStack
{
    int top;
	int arr[] = new int[1000];

    MyStack()
	{
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int v)
	{
	    // Your code here
	   if (isFull()) return;
	   this.top = this.top+1;
	   arr[this.top]=v;
	} 
	
    //Function to remove an item from top of the stack.
	int pop()
	{
        // Your code here
        if (isEmpty()) return -1;
        return arr[top--];
	}
	
	public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == 1000 - 1);
    }
    
} */ // this is not needed