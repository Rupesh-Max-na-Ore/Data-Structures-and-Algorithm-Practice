package StackAndQueue.Lec1_Learning;
/*Q2 Queue using Arrays */
// Some Comments added by AI 
// Assuming Queue is circular, which is generally the case
public class Queue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int maxSize;

    // Constructor to initialize the queue
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue method to add an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize; // Circular increment
        queueArray[rear] = value;
        size++;
    }

    // Dequeue method to remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue");
            return -Integer.MAX_VALUE; // Indicates the queue is empty
        }
        int dequeuedValue = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment
        size--;
        return dequeuedValue;
    }

    // Peek method to return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek");
            return -1; // Indicates the queue is empty
        }
        return queueArray[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (size == maxSize);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element is: " + queue.peek()); // should print 10

        queue.enqueue(60); // should print "Queue is full. Cannot enqueue 60"

        while (!queue.isEmpty()) {
            System.out.println("Dequeued element is: " + queue.dequeue());
        }

        System.out.println("Queue empty: " + queue.isEmpty()); // should print true
    }
}

/*//GFG soln.
class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
    
	
	//Function to push an element x in a queue.
    void push(int x)
    	{
    	    if(rear == arr.length) {
            //shift back all (front to rear elems.)
                for(int i=front;i<rear;i++) {
    	            arr[i-front] = arr[i];
    	        }
    	        front = 0;
    	        rear -= front;
    	    }
    	    arr[rear++] = x;
    	}

    //Function to pop an element from queue and return that element.
	int pop()
	{
	    if(front == rear) return -1;
	    return arr[front++];
	} 
    
}
 */