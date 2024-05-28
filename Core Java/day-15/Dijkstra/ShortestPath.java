/*Task 1: Dijkstra’s Shortest Path Finder
Code Dijkstra’s algorithm to find the shortest path from a start node to every other node in a weighted graph with positive weights.*/

package day15;

import java.util.*;

class Graph {
    private int vertices;
    private List<List<Node>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjacencyList.get(u).add(new Node(v, weight));
        adjacencyList.get(v).add(new Node(u, weight)); // If the graph is undirected
    }

    public int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, new Node());
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.node;

            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;

                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        return distances;
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.cost, node2.cost);
    }
}