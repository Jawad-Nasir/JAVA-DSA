// implementing queue using Array

class  queue {
    int arr[];
    int size;
    int rear = -1;

    queue (int n) {
        arr = new int[n];
        this.size = n;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    // enqueue
    public void add(int data) {
        if (rear == size-1) {
            System.out.println("Full Queue");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    // dequeue
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int front = arr[0];
    
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return arr[0];
    }
    
    // print queue
    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }    
}

public class Queue1 {    
    public static void main(String[] args) {
        queue q = new queue(4);
        q.add(1);        
        q.add(2);        
        q.add(3); 
        q.print();       
    }    
}
