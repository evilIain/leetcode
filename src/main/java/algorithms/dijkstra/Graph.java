package algorithms.dijkstra;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    private Map<Node, Integer> costs = new HashMap<>();

    private Map<Node, Node> parents = new HashMap<>();

    public void addNode(Node node) {
        nodes.add(node);
        costs.put(node, Integer.MAX_VALUE);
        parents.put(node, null);
    }

    public static Graph buildGraph() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addWeight(nodeB, 5);
        nodeA.addWeight(nodeC, 2);

        nodeB.addWeight(nodeD, 4);
        nodeB.addWeight(nodeE, 2);

        nodeC.addWeight(nodeB, 8);
        nodeC.addWeight(nodeE, 7);

        nodeD.addWeight(nodeE, 6);
        nodeD.addWeight(nodeF, 3);

        nodeE.addWeight(nodeF, 1);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph.getCosts().put(nodeB, 5);
        graph.getCosts().put(nodeC, 2);

        graph.getParents().put(nodeB, nodeA);
        graph.getParents().put(nodeC, nodeA);

        return graph;
    }
}
