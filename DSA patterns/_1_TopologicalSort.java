// package DSA.patterns;

import java.util.List;
import java.util.*;

public class _1_TopologicalSort {

    // Helper function for DFS
    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        // Mark node as visited
        visited[node] = true;

        // Visit all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }

        // Once all neighbors are processed, push current node to stack
        stack.push(node);
    }

    // Function to perform topological sort
    private static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Run DFS from all unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        // Pop all elements from stack to get topological order
        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        int V = 6; // number of vertices

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example edges (Directed Graph)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Perform Topological Sort
        List<Integer> topoOrder = topologicalSort(V, adj);

        // Print the result
        System.out.println("Topological Sort (DFS): " + topoOrder);
    }
}
