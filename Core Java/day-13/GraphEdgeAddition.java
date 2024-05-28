package day13;
import java.util.*;

public class GraphEdgeAddition {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> whiteSet = new HashSet<>();
    private Set<Integer> graySet = new HashSet<>();
    private Set<Integer> blackSet = new HashSet<>();

    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public boolean addEdge(int from, int to) {
        addNode(from);
        addNode(to);
        adjList.get(from).add(to);
        if (checkCycle()) {
            adjList.get(from).remove(adjList.get(from).size() - 1);
            return false;
        }
        return true;
    }

    private boolean checkCycle() {
        whiteSet.addAll(adjList.keySet());
        while (!whiteSet.isEmpty()) {
            int current = whiteSet.iterator().next();
            if (dfs(current)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int current) {
        moveNode(current, whiteSet, graySet);
        for (int neighbor : adjList.get(current)) {
            if (blackSet.contains(neighbor)) {
                continue;
            }
            if (graySet.contains(neighbor)) {
                return true;
            }
            if (dfs(neighbor)) {
                return true;
            }
        }
        moveNode(current, graySet, blackSet);
        return false;
    }

    private void moveNode(int node, Set<Integer> sourceSet, Set<Integer> destinationSet) {
        sourceSet.remove(node);
        destinationSet.add(node);
    }

    public static void main(String[] args) {
        GraphEdgeAddition graph = new GraphEdgeAddition();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);

        System.out.println("Edge added? " + graph.addEdge(0, 1)); // true
        System.out.println("Edge added? " + graph.addEdge(1, 2)); // true
        System.out.println("Edge added? " + graph.addEdge(2, 0)); // false, because it introduces a cycle
    }
}

