package codinginterview.treesgraphs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Tree {

    private Node root;

    @Getter
    @Setter
    @ToString(exclude = {"left", "right"})
    public static class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        root = addNode(root, value);
    }

    public Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addNode(current.left, value);
        } else if (value > current.value){
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public Node find(int value) {
        return findElement(root, value);
    }


    public Node findElement(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value == value) {
            return current;
        }
        return value < current.value ? findElement(current.left, value) : findElement(current.right, value);
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.right == null && current.left == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            int minValue = findMinValue(current.right);
            current.value = minValue;
            current.right = deleteNode(current.right, minValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteNode(current.left, value);
            return current;
        }
        current.right = deleteNode(current.right, value);
        return current;
    }

    private int findMinValue(Node root) {
        return root.left == null ? root.value : findMinValue(root.left);
    }

    public static void main(String[] args) {
        Tree bt = new Tree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.delete(8);
    }
}
