package codinginterview.linkedlists;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Palindrome_2_6 {

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

    public static Node reverse(Node node) {
        Node head = null;
        while (node != null) {
            Node temp = new Node(node.data);
            temp.next = head;
            head = temp;
            node = node.next;
        }
        return head;
    }

    public static boolean isPalindrome(Node node, Node reversed) {
        while (node != null && reversed != null) {
            if (node.data != reversed.data)
                return false;
            node = node.next;
            reversed = reversed.next;
        }
        return node == null && reversed == null;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(2);
        node.append(3);
        node.append(3);
        node.append(2);
        node.append(1);
        Node reversed = reverse(node);
        System.out.println(isPalindrome(node, reversed));
    }
}
