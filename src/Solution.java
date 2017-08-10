import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    // class constructor
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    // method that will get height, accepts node as arg
    public static int getHeight(Node root) {
        // base case for recursion
        if (root == null) {
            return -1;
        }

        int lefth = getHeight(root.left);
        int righth = getHeight(root.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data); //creates new node first time
        } else {
            Node cur;
            if (data <= root.data) { //compares root.data to new data
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of nodes
        Node root = null;
        while (T-- > 0) { // decrements T, while T greater than 0.
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}