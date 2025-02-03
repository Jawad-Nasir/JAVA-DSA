// implementing queue using LinkedList

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class queue {
    Node front = null;
    Node rear = null; 

    public boolean isEmpty() {
        return rear == null && front == null;
    }

    // enqueue
    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // dequeue
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int result = front.data;
        if (front == rear) {
            rear = null;
        }
        front = front.next;
        return result;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return front.data;
    }

    // print queue
    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }
}

public class Queue3 {
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);        
        q.add(2);        
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add(5);
        q.add(3);
        q.print();     
    }    
}

 

