package algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

class Gfg
{
    public static class Node
    {
        int data;
        Node left, right;

        // constructor
        Node(int key)
        {
            data = key;
            left = null;
            right = null;
        }
    };


    public static Node deepestNode(Node root)
    {
        Node tmp = null;
        if (root == null)
            return null;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty())
        {
            tmp = q.remove();
            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
        return tmp;
    }

    public static void main(String[] args)
    {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);

        Node deepNode = deepestNode(root);
        System.out.println(deepNode.data);
    }
}
