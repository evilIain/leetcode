package codinginterview.linkedlists;

import lombok.Getter;
import lombok.Setter;

public class SumLists_2_5 {

    @Getter
    @Setter
    private static class Node {
        Node next = null;
        int data;

        public Node() {
        }

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

    public static Node sumLists(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0)
            return null;

        Node result = new Node();
        int value = carry;
        if (n1 != null) {
            value = value + n1.data;
        }
        if (n2 != null) {
            value = value + n2.data;
        }

        result.data = value % 10;

        if (n1 != null || n2 != null) {
            result.next = sumLists(n1 == null ? null : n1.next,
                                 n2 == null ? null : n2.next,
                                 value >= 10 ? 1 : 0);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
