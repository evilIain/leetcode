package algorithms.dijkstra;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Node {

    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    private Map<Node, Integer> neighbors = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addWeight(Node target, Integer weight) {
        neighbors.put(target, weight);
    }

    public String printShortestPath() {
        StringBuilder builder = new StringBuilder();
        shortestPath.forEach(node -> builder.append(node.getName()).append("-->"));
        builder.append(this.getName());
        return builder.toString();
    }

}
