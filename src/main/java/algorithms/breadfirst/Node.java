package algorithms.breadfirst;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Node<T> {

    private T value;
    private Set<Node<T>> neighbors = new HashSet<>();

    public Node(T value) {
        this.value = value;
    }

    public void connect(Node<T> node) {
        if (this == node)
            throw new IllegalArgumentException("Can't wire node to itself");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    public static Node<Neighbor> buildGraph() {
        Node<Neighbor> root = new Node<>(new Neighbor("Me"));
        Node<Neighbor> bob = new Node<>(new Neighbor("Bob"));
        Node<Neighbor> claire = new Node<>(new Neighbor("Claire"));
        Node<Neighbor> alice = new Node<>(new Neighbor("Alice"));
        Node<Neighbor> anuj = new Node<>(new Neighbor("Anuj", true));
        Node<Neighbor> thom = new Node<>(new Neighbor("Thom"));
        Node<Neighbor> johhny = new Node<>(new Neighbor("Johhny"));
        Node<Neighbor> peggy = new Node<>(new Neighbor("Peggy"));

        root.connect(bob);
        root.connect(alice);
        root.connect(claire);

        bob.connect(peggy);
        bob.connect(anuj);

        alice.connect(peggy);

        claire.connect(thom);
        claire.connect(johhny);

        return root;
    }
}
