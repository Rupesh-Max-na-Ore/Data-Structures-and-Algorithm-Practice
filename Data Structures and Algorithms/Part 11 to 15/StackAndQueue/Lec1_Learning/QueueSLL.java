package StackAndQueue.Lec1_Learning;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

/*Q6 Queue using SLL */
public class QueueSLL {
    private Node front;
    private Node rear;

    // Constructor to initialize the queue
    public QueueSLL() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue method to add an element to the end of the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {// When 1st node, put both F and R on it
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue method to remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue");
            return -1; // Indicates the queue is empty
        }
        int dequeuedValue = front.value;
        front = front.next;
        if (front == null) {
            rear = null; // When Queue emptied
        }
        return dequeuedValue;
    }

    // Peek method to return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek");
            return -1; // Indicates the queue is empty
        }
        return front.value;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        QueueSLL queue = new QueueSLL();

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
/*//GFG submission
class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode newNode = new QueueNode(a);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if (front == null) return -1; 
        
        int dequeuedValue = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedValue;
	}
}
 */