package algorithms.dijkstra;

import java.util.*;

public class DijkstraAlgorithm {

    public static Graph findShortestPath(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> unhandledNodes = new HashSet<>();
        Set<Node> handledNodes = new HashSet<>();

        unhandledNodes.add(source);

        while(!unhandledNodes.isEmpty()) {
            Node node = findCheapestNode(unhandledNodes);
            unhandledNodes.remove(node);

            for(var entry : node.getNeighbors().entrySet()) {
                Node neighborNode = entry.getKey();
                Integer weight = entry.getValue();
                if (!handledNodes.contains(neighborNode)) {
                    calculateShortestPath(node, neighborNode, weight);
                    unhandledNodes.add(neighborNode);
                }
            }
            handledNodes.add(node);
        }

        return graph;
    }

    private static Node findCheapestNode(Set<Node> unhandledNodes) {
        Node cheapestNode = null;
        int distance = Integer.MAX_VALUE;

        for (Node node : unhandledNodes) {
            if (node.getDistance() < distance) {
                cheapestNode = node;
                distance = node.getDistance();
            }
        }

        return cheapestNode;
    }

    private static void calculateShortestPath(Node sourceNode, Node targetNode, Integer weight) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + weight < targetNode.getDistance()) {
            List<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            targetNode.setShortestPath(shortestPath);
            targetNode.setDistance(sourceDistance + weight);
        }
    }

    public static void main(String[] args) {
        Graph graph = Graph.buildGraph();
        Node source = graph.getNodes().stream().filter(n -> n.getName().equals("A")).findFirst().get();
        findShortestPath(graph, source);
        graph.getNodes().forEach(
                node -> System.out.println("path to " + node.getName() + ": " + node.printShortestPath())
        );
    }
}
