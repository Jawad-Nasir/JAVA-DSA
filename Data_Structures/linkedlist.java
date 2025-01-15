class Node {
    String data;
    Node next;
    
    Node(String data){
        this.data = data;
        this.next = null;
    }
}

class LL {
    Node head = null;
    private int size;
    
    LL(){
        this.size = 0; 
    }
    
    //add node at first
    public void addFirst(String data){
        
        Node newNode = new Node(data);
        size++;   
        if (head == null) {
            head = newNode;
            return;     
        } 

        newNode.next = head;
        head = newNode;
    }
    
    //add node at last 
    public void addLast(String data){
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;     
        } 

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    //printing the list 
    public void printlist(){
        if (head == null) {
            System.out.println("list is empty!");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    //delete first node
    public void deleteFirst(){
        if (head == null) {
            System.out.println("list is empty!");
            return; 
        } 

        head = head.next;
        size--;
    }

    //delete last node
    public void deleteLast(){
        if (head == null) {
            System.out.println("list is empty!");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondlast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondlast = secondlast.next; 
        }

        secondlast.next = null;
    }
    //get size of a list
    public int getSize(){
        return size;
    }

    
}
  
public class linkedlist {
    public static void main(String[] args) {
        LL list = new LL();
        // list.addFirst("1");
        // list.addLast("2");
        list.addLast("2");
        list.addLast("1");
        list.printlist();
        
    }    
}
