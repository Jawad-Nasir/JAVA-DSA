// implementing stack using arraylist

import java.util.ArrayList;


class stack2 {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    // push
    public void push(int data) {
        list.add(data);        
    }

    // pop
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        int top = list.get(list.size()-1);
        return top;
    }

    // printing elements
    public void print() {
        while (!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }
} 

public class Stack2 {
    public static void main(String[] args) {
        stack2 s = new stack2();
        s.push(1);        
        s.push(2);        
        s.push(3);
        s.push(4);
        s.pop();
        s.print();
    }
}
