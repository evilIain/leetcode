package algorithms.dijkstra.alternative;

import java.util.*;

public class AltDijkstraAlgorithm {

    public static List<Node> findShortestPath(Graph graph, Node source, Node target) {

        Set<Node> processed = new HashSet<>();
        Map<Node, Integer> costs = graph.getCosts();
        Map<Node, Node> parents = graph.getParents();

        Node currentNode = findLowestCostNode(graph.getCosts(), processed);

        while (currentNode != null) {
            int cost = costs.get(currentNode);
            Map<Node, Integer> neighbors = currentNode.getNeighbors();
            for (var entry : neighbors.entrySet()) {
                int newCost = cost + entry.getValue();
                if (costs.get(entry.getKey()) > newCost) {
                    costs.put(entry.getKey(), newCost);
                    parents.put(entry.getKey(), currentNode);
                }
            }
            processed.add(currentNode);
            currentNode = findLowestCostNode(graph.getCosts(), processed);
        }

        List<Node> result = new ArrayList<>();
        buildPath(result, parents, source, target);
        return result;
    }

    public static Node findLowestCostNode(Map<Node, Integer> costs, Set<Node> processed) {
        Integer cost = Integer.MAX_VALUE;
        Node lowestNode = null;
        for(var entry : costs.entrySet()) {
            if (entry.getValue() < cost && !processed.contains(entry.getKey())) {
                lowestNode = entry.getKey();
                cost = entry.getValue();
            }
        }

        return lowestNode;
    }

    public static void buildPath(List<Node> result, Map<Node, Node> parents, Node source, Node target) {
        if (parents.get(target).equals(source)) {
            result.add(source);
        } else {
            buildPath(result, parents, source, parents.get(target));
            result.add(parents.get(target));
        }
    }

    public static void main(String[] args) {
        Graph graph = Graph.buildGraph();
        Node source = graph.getNodes().stream().filter(n -> n.getName().equals("A")).findFirst().get();
        Node target = graph.getNodes().stream().filter(n -> n.getName().equals("F")).findFirst().get();
        List<Node> result = findShortestPath(graph, source, target);
        System.out.println(result);
    }
}
