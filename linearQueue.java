package DSA_queue;

public class linearQueue {

        private final int maxSize;
        private final int[] queueArray;
        private int front;
        private int rear;
        private int currentSize;

        public linearQueue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
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
                System.out.println(STR."Queue is full. Cannot enqueue \{data}");
                return;
            }
            rear = (rear + 1) % maxSize;
            queueArray[rear] = data;
            currentSize++;
            System.out.println(STR."\{data} enqueued to the queue.");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }
            int data = queueArray[front];
            front = (front + 1) % maxSize;
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
                System.out.print(STR."\{queueArray[index]} ");
                index = (index + 1) % maxSize;
                count++;
            }
            System.out.println();
        }


    }

