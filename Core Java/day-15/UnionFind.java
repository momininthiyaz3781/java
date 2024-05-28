/*task-3:
Union-Find for Cycle Detection:
Write a Union-Find data structure with path compression. Use this data structure to detect a cycle in an undirected graph.show in java*/
package day15;
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            // Both nodes belong to the same set, indicating a cycle
            System.out.println("Graph contains a cycle.");
        } else {
            // Union by rank
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 9; // Number of vertices in the graph
        UnionFind uf = new UnionFind(n);

        // Example edges (modify as needed)
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(1, 3);
        uf.union(3, 4);
        uf.union(2, 4);

        // Check if a cycle exists
        // You can add more edges and call uf.union() as needed
    }
}