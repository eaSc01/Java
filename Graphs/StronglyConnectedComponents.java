package Graphs;

import java.util.*;

// Kosaraju Algo
public class StronglyConnectedComponents {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void topSort(int curr, List<Edge>[] graph, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;

            if (!vis[neighbour]) {
                topSort(neighbour, graph, vis, s);
            }
        }

        s.push(curr);
    }

    public static void stronglyConnectedComponents(List<Edge>[] graph) {
        
        // Step 1: Topological order
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSort(i, graph, vis, stack);
            }
        }
        
        // Step 2: Transpose Graph
        @SuppressWarnings("unchecked")
        List<Edge>[] transpose = new ArrayList[graph.length];

        for (int i = 0; i < transpose.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i<graph.length; i++) {
            for (int j = 0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }            
        }
        

        // Step 3: DFS on transpose graph in the order of stack elements
        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!vis[curr]) {
                dfs(curr, transpose, vis);
                System.out.println();
            }
        }
    }

    public static void dfs(int curr, List<Edge>[] graph, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;

            if (!vis[neighbour]) {
                dfs(neighbour, graph, vis);
            }
        }
    }

    public static void createGraph(List<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[5];
        createGraph(graph);

        stronglyConnectedComponents(graph);

    }
}
