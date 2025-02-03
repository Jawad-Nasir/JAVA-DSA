// implementing stack using linkedlists 

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}    

class stack {
    public Node head;
    
    // checking if stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // pushing to stack
    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // poping from stack
    public int pop() {
        if (isEmpty()) {
            return -1;
        } 
        int top = head.data;
        head = head.next;
        return top;
    }

    // peeking into stack
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data; 
    }

    // printing stack
    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }

}

public class Stack1 {
   public static void main(String[] args) {
        stack s = new stack();
        s.push(1);        
        s.push(2);        
        s.push(3);        
        s.pop();
        s.push(4);
        s.print();
        
        
   }
}
