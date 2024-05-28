package day16;
//task:1
//Kruskal’s Algorithm for MST Implement Kruskal’s algorithm to find the minimum spanning tree of a given connected, undirected graph with non-negative edge weights

import java.util.*;

public class KruskalsAlgorithm {
  // Edge class representing an edge in the graph
  static class Edge implements Comparable<Edge> {
      int src, dest, weight;

      // Comparator function used for sorting edges based on their weight
      public int compareTo(Edge compareEdge) {
          return this.weight - compareEdge.weight;
      }
  }

  // Subset class used for union-find
  static class Subset {
      int parent, rank;
  }

  int V, E; // V = number of vertices, E = number of edges
  Edge[] edge; // Array of edges

  // Constructor
  KruskalsAlgorithm(int v, int e) {
      V = v;
      E = e;
      edge = new Edge[E];
      for (int i = 0; i < e; ++i)
          edge[i] = new Edge();
  }

  // Function to find set of an element i (uses path compression)
  int find(Subset[] subsets, int i) {
      if (subsets[i].parent != i)
          subsets[i].parent = find(subsets, subsets[i].parent);
      return subsets[i].parent;
  }

  // Function to union two sets of x and y (uses union by rank)
  void union(Subset[] subsets, int x, int y) {
      int xroot = find(subsets, x);
      int yroot = find(subsets, y);

      // Attach smaller rank tree under root of high rank tree
      if (subsets[xroot].rank < subsets[yroot].rank)
          subsets[xroot].parent = yroot;
      else if (subsets[xroot].rank > subsets[yroot].rank)
          subsets[yroot].parent = xroot;
      else {
          subsets[yroot].parent = xroot;
          subsets[xroot].rank++;
      }
  }

  // Main function to construct MST using Kruskal's algorithm
  void kruskalMST() {
      Edge[] result = new Edge[V]; // This will store the resultant MST
      int e = 0; // An index variable for result[]
      int i = 0; // An index variable for sorted edges
      for (i = 0; i < V; ++i)
          result[i] = new Edge();

      // Step 1: Sort all the edges in non-decreasing order of their weight
      Arrays.sort(edge);

      // Allocate memory for creating V subsets
      Subset[] subsets = new Subset[V];
      for (i = 0; i < V; ++i)
          subsets[i] = new Subset();

      // Create V subsets with single elements
      for (int v = 0; v < V; ++v) {
          subsets[v].parent = v;
          subsets[v].rank = 0;
      }

      i = 0; // Index used to pick the smallest edge

      // Number of edges to be taken is equal to V-1
      while (e < V - 1) {
          // Step 2: Pick the smallest edge. And increment the index for next iteration
          Edge nextEdge = edge[i++];

          int x = find(subsets, nextEdge.src);
          int y = find(subsets, nextEdge.dest);

          // If including this edge does not cause cycle, include it in result
          // and increment the index of result for next edge
          if (x != y) {
              result[e++] = nextEdge;
              union(subsets, x, y);
          }
      }

      // Print the contents of result[] to display the MST
      System.out.println("Following are the edges in the constructed MST");
      for (i = 0; i < e; ++i)
          System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
  }

  // Driver Code
  public static void main(String[] args) {
      int V = 4; // Number of vertices in graph
      int E = 5; // Number of edges in graph
      KruskalsAlgorithm graph = new KruskalsAlgorithm(V, E);

      // add edge 0-1
      graph.edge[0].src = 0;
      graph.edge[0].dest = 1;
      graph.edge[0].weight = 10;

      // add edge 0-2
      graph.edge[1].src = 0;
      graph.edge[1].dest = 2;
      graph.edge[1].weight = 6;

      // add edge 0-3
      graph.edge[2].src = 0;
      graph.edge[2].dest = 3;
      graph.edge[2].weight = 5;

      // add edge 1-3
      graph.edge[3].src = 1;
      graph.edge[3].dest = 3;
      graph.edge[3].weight = 15;

      // add edge 2-3
      graph.edge[4].src = 2;
      graph.edge[4].dest = 3;
      graph.edge[4].weight = 4;

      graph.kruskalMST();
  }
}
