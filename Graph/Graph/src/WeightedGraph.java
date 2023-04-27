import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int id;

    public Node(int id) {
        this.id = id;
    }
}

class Edge {
    Node source;
    Node destination;
    double weight;

    Edge(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class WeightedGraph {
    List<Node> nodes;
    List<Edge> edges;

    public WeightedGraph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(int id) {
        nodes.add(new Node(id));
    }

    public void addEdge(int sourceId, int destId, double weight) {
        Node source = getNode(sourceId);
        Node destination = getNode(destId);
        edges.add(new Edge(source, destination, weight));
    }

    private Node getNode(int id) {
        for (Node node : nodes) {
            if (node.id == id) {
                return node;
            }
        }
        return null;
    }

    public void printGraph() {
        for (Node node : nodes) {
            System.out.println("Node " + node.id);
        }

        for (Edge edge : edges) {
            if (edge.source != null) {
                System.out.println("Node:" + edge.source.id + "-----" +  "Weight:" +edge.weight + "-----" + "Node:" + edge.destination.id);
            }
        }
    }
    public WeightedGraph getMinimumSpanningTree() {
        WeightedGraph MST = new WeightedGraph();
        if (nodes.isEmpty()) {
            return MST;
        }

        // Create a priority queue to store edges
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));

        // Add all edges to the priority queue
        edgeQueue.addAll(edges);

        // Create a list to track visited nodes
        List<Node> visitedNodes = new ArrayList<>();

        // Add the first node to the visited list
        visitedNodes.add(nodes.get(0));

        while (visitedNodes.size() < nodes.size()) {
            // Get the edge with the minimum weight
            Edge edge = edgeQueue.poll();

            // Skip the edge if it creates a cycle
            if (visitedNodes.contains(edge.source) && visitedNodes.contains(edge.destination)) {
                continue;
            }

            // Add the edge to the minimum spanning tree
            MST.addEdge(edge.source.id, edge.destination.id, edge.weight);

            // Add the newly visited node to the visited list
            Node newNode = visitedNodes.contains(edge.source) ? edge.destination : edge.source;
            visitedNodes.add(newNode);
        }

        return MST;
    }
}
