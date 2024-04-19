package DSA_queue;

public class circularQueue {

        private final int maxSize;
        private final int[] queueArray;
        private int front;
        private int rear;
        private int currentSize;

        public circularQueue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = -1;
            rear = -1;
            currentSize = 0;
        }

        public boolean isEmpty() {
            return (currentSize == 0);
        }

        public boolean isFull() {
            return (currentSize == maxSize);
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot enqueue " + data);
                return;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % maxSize;
            queueArray[rear] = data;
            currentSize++;
            System.out.println(data + " enqueued to the queue.");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }
            int data = queueArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
            currentSize--;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot peek.");
                return -1;
            }
            return queueArray[front];
        }

        public int size() {
            return currentSize;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Nothing to display.");
                return;
            }
            System.out.print("Queue: ");
            int count = 0;
            int index = front;
            while (count < currentSize) {
                System.out.print(queueArray[index] + " ");
                index = (index + 1) % maxSize;
                count++;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            circularQueue queue = new circularQueue(5);

            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);
            queue.enqueue(50);

            queue.display();  // Output: Queue: 10 20 30 40 50

            System.out.println("Front element: " + queue.peek());  // Output: Front element: 10

            System.out.println("Dequeued element: " + queue.dequeue());  // Output: Dequeued element: 10

            queue.display();  // Output: Queue: 20 30 40 50

            System.out.println("Queue size: " + queue.size());  // Output: Queue size: 4
        }
    }

