// implementing queue using Stacks

import java.util.Stack;

public class Queue_Algos {
    private Stack<Integer> first; 
    private Stack<Integer> second; 

    public Queue_Algos() {
        first = new Stack<>();
        second = new Stack<>(); 
    }

    public void Enqueue(int data) {
        first.push(data);
    }

    public  void Dequeue() {
        while (!first.isEmpty()) {
            int val = first.pop();
            second.push(val);
        }

        second.pop();

        while (!second.isEmpty()) {
            int val = second.pop();
            first.push(val);
        }
    }

    public  void printQueue() {
        while (!first.isEmpty()) {
            System.out.println(first.peek());
            first.pop();
        }
    } 

    public static void main(String[] args) {
        Queue_Algos q1 = new Queue_Algos();
        q1.Enqueue(1);
        q1.Enqueue(2);
        q1.Enqueue(3);
        q1.Enqueue(4);
        q1.Dequeue();
        q1.printQueue();
        
    }
}
