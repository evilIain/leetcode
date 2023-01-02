package algorithms.dijkstra.alternative;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Node {

    private String name;

    private Map<Node, Integer> neighbors = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addWeight(Node target, Integer weight) {
        neighbors.put(target, weight);
    }

    @Override
    public String toString() {
        return name + "-->";
    }
}
