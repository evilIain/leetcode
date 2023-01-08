package codinginterview.linkedlists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class RemoveFromMiddle_2_3 {
    @Getter
    @Setter
    @ToString
    private static class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public void append(int data) {
            Node newNode = new Node(data);
            Node current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(2);
        node.append(3);
        node.append(4);
        node.append(3);
        node.append(5);
        deleteNode(node.next.next);
        System.out.println("finish");
    }

}
