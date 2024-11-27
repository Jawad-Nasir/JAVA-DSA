class Node {
    String data;
    Node next;
    
    Node(String data){
        this.data = data;
        this.next = null;
    }
}

class LList {
    Node head = null;
  
    //adding a node in the last
    public void addLast(String data){
        Node newNode = new Node(data);

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

    //reverse a list through iteration 
    public void reverseIteration(){
        if (head == null || head.next == null) {
            return; 
        }
        
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update for next iteration
            prevNode = currNode;
            currNode = nextNode; 
        }
        head.next = null;
        head = prevNode;
    }
    
    //reverse a list through recursion
    public Node reverseRecursion(Node head){
        
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    
    //delete nth node from the end of list 
    public Node removeNthFromEnd(Node head, int n){
        if (head.next == null) {
            return null;
        }
        //find size of list
        int size = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            size++; 
        } 

        if (n == size) {
            return head.next;
        }

        //find nth node 
        int indxToSearch = size - n;
        Node prev = head;
        int i = 1;
        while (i < indxToSearch) {
            prev = prev.next;
            i++;
        }   
        //remove nth node 
        prev.next = prev.next.next;
        return head;
    }
    
    //find middle node of a linkedlist
    public Node findMiddle(Node head){
        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }

    //validating linkedlist as palindrom
    public boolean isPalindrom(Node head){
        if (head == null || head.next == null) {
            return true;                   
        }
        //dividing the linkedlist into two
        Node middle = findMiddle(head);
        Node secHalfStart = reverseRecursion(middle.next);

        Node firstHalfStart = head;
        while (secHalfStart != null) {
            if (firstHalfStart.data != secHalfStart.data) {
                return false;
            }            
            firstHalfStart = firstHalfStart.next;
            secHalfStart = secHalfStart.next;
        }
        return true;
    }

    //detecting cycle
    public boolean hasCycle(Node head){
        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle) {
                return true;
            } 
        } 
        return false;
    }
    
}

public class linkedlist_Algos {
    public static void main(String[] args) {
        LList list = new LList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("4");
        list.addLast("1");
        list.addLast("5");
        list.printlist();
        // System.out.println(list.hasCycle(list.head));
        System.out.println(list.isPalindrom(list.head));
        // list.head = list.removeNthFromEnd(list.head, 2);
        // list.reverseIteration();
        // list.head = list.reverseRecursion(list.head);
        // list.printlist();
    }    
}
