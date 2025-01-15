// implementing BST

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
    
        public Node(int data) {
            this.data = data;
        } 
    }
    
    // insert a value in BST 
    public static Node insert(int val, Node node) {
        if (node == null) {
            Node newNode = new Node(val);
            return newNode;
        }

        if (val < node.data) {
            node.left = insert(val, node.left);
        }

        if (val > node.data) {
            node.right = insert(val, node.right);
        }

        return node;
    } 

    // display BST
    public static void displayBSTInorder(Node root) {
        if (root == null) {
            return;
        }

        displayBSTInorder(root.left);
        System.out.print(root.data + " ");
        displayBSTInorder(root.right);
    }

    // search if a value is present in BST  
    public static boolean search(int val, Node node) {
        if (node == null) {
            return false;
        } else if (val == node.data) {
            return true;
        }
        
        if (val < node.data) {
            return search(val, node.left);
        } else {
            return search(val, node.right);
        }
    }
    
    // delete a value in BST 
    public static Node delete(int val, Node node) {
        if (node == null) {
            return null;
        }
        // search node to delete
        if (val < node.data) {
            node.left = delete(val, node.left);
        }
        else if (val > node.data) {
            node.right = delete(val, node.right); 
        }
        else {
            // case01 - no child node
            if (node.right == null && node.left == null) {
                return null;
            } 
            // case02 - one child node
            if (node.right == null) {
                return node.left;
            }
            else if (node.left == null) {
                return node.right;
            }
            // case03 - two child node 
            Node IS = inorderSuccessor(node.right);
            node.data = IS.data;
            node.right = delete(IS.data, node.right);
        }

        return node;
    }

    public static Node inorderSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // print value in particular range
    public static void printInRange(Node node, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.data >= x && node.data <= y) {
            printInRange(node.left, x, y);
            System.out.print(node.data + " ");
            printInRange(node.right, x, y);
        }
        else if (node.data >= y) {
            printInRange(node.left, x, y);
        }
        else {
            printInRange(node.right, x, y);
        }
    }

    public static void main(String[] args) {
        int[] value = {8,5,3,1,4,6,10,11,14};
        Node root = null; 

        for (int i = 0; i < value.length; i++) {
            root = insert(value[i], root);
        }

        displayBSTInorder(root);
        System.out.println(); 
        // System.out.println(search(2, root));
        // delete(12, root);
        // displayBSTInorder(root);
        printInRange(root, 6, 11);
    }
}
