package codinginterview.linkedlists;

import lombok.Getter;
import lombok.Setter;

public class ReturnKToLast_2_2 {

    @Getter
    @Setter
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

    public static Node findElement(Node head, int k) {
        Node n1 = head;
        Node n2 = head;

        for (int i = 0; i < k; i++) {
            if (n1.next == null) {
                return null;
            }
            n1 = n1.next;
        }

        while (n1.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(2);
        node.append(3);
        node.append(4);
        node.append(3);
        node.append(5);
        Node result = findElement(node, 4);
        System.out.println(result == null ? null : result.getData());
    }
}
