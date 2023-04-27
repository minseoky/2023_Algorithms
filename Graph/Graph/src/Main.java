public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 5);

        graph.getMinimumSpanningTree().printGraph();
    }
}