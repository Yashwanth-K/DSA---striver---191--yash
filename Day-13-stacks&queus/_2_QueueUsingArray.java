public class _2_QueueUsingArray {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor
    public _2_QueueUsingArray(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Enqueue operation: O(1) time
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
    }

    // Dequeue operation: O(1) time
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queueArray[front]; 
        front = (front + 1) % maxSize;
        currentSize--;
        return value;
    }

    // Peek operation: O(1) time
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[front];
    }

    // Check if queue is empty: O(1) time
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Check if queue is full: O(1) time
    public boolean isFull() {
        return (currentSize == maxSize);
    }
}
// Time Complexity:
// - Enqueue: O(1)
// - Dequeue: O(1)
// - Peek: O(1)
// - isEmpty: O(1)
// - isFull: O(1)
// Space Complexity: O(n), where n is the maxSize of the queue