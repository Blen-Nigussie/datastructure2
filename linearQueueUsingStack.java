package DSA_queue;

import java.util.Stack;
public class linearQueueUsingStack {

        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public linearQueueUsingStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public void enqueue(int data) {
            stack1.push(data);
            System.out.println(data + " enqueued to the queue.");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot peek.");
                return -1;
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Nothing to display.");
                return;
            }

            System.out.print("Queue: ");
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }

            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }

            System.out.println();
        }


    }

