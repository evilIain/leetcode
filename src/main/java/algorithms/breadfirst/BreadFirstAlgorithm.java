package algorithms.breadfirst;

import java.util.*;

public class BreadFirstAlgorithm {

    public static Optional<String> findSeller(Node<Neighbor> root) {
        Set<Node<Neighbor>> visited = new HashSet<>();
        Queue<Node<Neighbor>> queue = new ArrayDeque<>();
        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<Neighbor> node = queue.remove();
            System.out.println("Visiting node: " + node.getValue().getLabel());
            if (node.getValue().isSeller()) {
                return Optional.of(node.getValue().getLabel());
            }
            visited.add(node);
            queue.addAll(node.getNeighbors());
            queue.removeAll(visited);
        }

        return Optional.empty();
    }

    public static void main(String[] args) {

        Node<Neighbor> root = Node.buildGraph();
        Optional<String> seller = findSeller(root);
        if (seller.isEmpty()) {
            System.out.println("Nobody is a seller");
        } else {
            System.out.println(seller.get() + " is a seller");
        }
    }

}
