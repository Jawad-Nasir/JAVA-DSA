// implementing circular queue using Array

class queue {
    int arr[];
    int size;
    int rear = -1;
    int front = -1;

    queue (int n) {
        arr = new int[n];
        this.size = n;
    }

    // function for checking queue is empty 
    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    // function for checking queue is full
    public boolean isFull() {
        return (rear+1) % size == front;
    }
    
    // enqueue
    public void add(int data) {
        if (isFull()) {
            System.out.println("Full Queue");
            return;
        }
        // add first element
        if (front == -1) {
            front = 0; 
        }
        rear = (rear+1) % size;
        arr[rear] = data;
    }

    // dequeue
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int result = arr[front];
        // for single element
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front+1) % size;
        }
        return result;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return arr[front];
    }

    // print queue
    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }
}

public class Queue2 {
    public static void main(String[] args) {
        queue q = new queue(4);
        q.add(1);        
        q.add(2);        
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add(1);
        q.add(2);
        q.print();     
    }    
}
