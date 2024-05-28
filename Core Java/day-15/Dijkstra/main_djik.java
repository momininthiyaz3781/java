package day15;


public class main_djik {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        int start = 0;
        int[] distances = graph.dijkstra(start);

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + " : " + distances[i]);
        }
    }
}
