import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    int idx = -1;

    // creating binarytree
    public Node buildtree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildtree(nodes);
        newNode.right = buildtree(nodes);

        return newNode;
    }

    // preorder traversal
    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // inorder traversal
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // postorder traversal
    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    // levelorder traversal
    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }        
    }

    // find average of nodes at each level 
    public List<Integer> averageLevel(Node root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int avg = 0;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node currNode = q.remove();
                avg += currNode.data;
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            avg /= levelSize;
            result.add(avg);
        }
        return result;
    }

    // count no. of nodes
    public int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    // sum of nodes
    public int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data; 
    }    
    
    // invert binarytree 
    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    // finding height of binarytree
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);
        
        return Math.max(leftHeight, rightHeight) + 1;
    } 
    
    // diameter of binarytree
    int diameter = 0;
    public int findDiameter(Node root) {
        // using height method to determine highest length b/w two nodes 
        height(root);
        return diameter;
    }
}

public class BinaryTrees {
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildtree(nodes);
        System.out.println(root.data);
        
        // inverting a tree
        tree.preorder(root);
        tree.invertTree(root);
        System.out.println();
        
        // traversals
        tree.preorder(root);
        tree.inorder(root); 
        tree.postorder(root);
        tree.levelOrder(root);

        System.out.println(tree.countOfNodes(root));        
        System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.height(root));
        System.out.println(tree.findDiameter(root));

        // calculating average of nodes at each level
        List<Integer> l = tree.averageLevel(root);
        for (Integer i : l) {
            System.out.print(i + " ");
        }
    }
}
