package codinginterview.linkedlists;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups_2_1 {

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

    public static void deleteDups(Node node) {
        Set<Integer> set = new HashSet<>();
        Node previous = null;
        while (node != null) {
            if (set.contains(node.getData())) {
                previous.next = node.next;
            } else {
                set.add(node.getData());
                previous = node;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(2);
        node.append(3);
        node.append(4);
        node.append(3);
        node.append(5);
        deleteDups(node);
    }
}
