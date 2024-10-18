package Graphs;

import java.util.*;;

public class CreateGraph {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static List<Edge>[] construct() {
        // Define the number of vertices in the graph
        int vertices = 5;
    
        // Create an array of lists to represent the adjacency list for the graph
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[vertices];
    
        // Initialize each list in the array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
    
        // Define edges for vertex 0
        graph[0].add(new Edge(0, 1, 4)); // Edge from 0 to 1 with weight 4
    
        // Define edges for vertex 1
        graph[1].add(new Edge(1, 0, 4)); // Edge from 1 to 0 with weight 4
        graph[1].add(new Edge(1, 2, 2)); // Edge from 1 to 2 with weight 2
        graph[1].add(new Edge(1, 3, 8)); // Edge from 1 to 3 with weight 8
        graph[1].add(new Edge(1, 4, -3)); // Edge from 1 to 4 with weight -3
    
        // Define edges for vertex 2
        graph[2].add(new Edge(2, 1, 2)); // Edge from 2 to 1 with weight 2
        graph[2].add(new Edge(2, 3, 6)); // Edge from 2 to 3 with weight 6
    
        // Define edges for vertex 3
        graph[3].add(new Edge(3, 2, 6)); // Edge from 3 to 2 with weight 6
        graph[3].add(new Edge(3, 1, 8)); // Edge from 3 to 1 with weight 8
    
        // Define edges for vertex 4
        graph[4].add(new Edge(4, 1, -3)); // Edge from 4 to 1 with weight -3
    
        // Return the constructed graph
        return graph;
    }
    

    public static List<Integer> getNeighbours(int e, List<Edge>[] graph) {
        List<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < graph[e].size(); i++) {
            neighbours.add(graph[e].get(i).dest);
        }
        return neighbours;
    }

    public static List<Integer> bfs(List<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];  // to mark visited nodes and avoid stucking in cycles
        List<Integer> allElements = new ArrayList<>();

        for (int i = 0; i<graph.length; i++) {
            if (!visited[i]) {
                allElements.addAll(bfsUtil(graph, visited, i));
            }
        }

        return allElements;
    }

    public static List<Integer> bfsUtil(List<Edge>[] graph, boolean[] visited, int first) {
        List<Integer> elements = new ArrayList<>(); // ans list
        Queue<Integer> q = new LinkedList<>();      // queue to process vertices
        q.add(first);  // init queue

        while (!q.isEmpty()) {
            // step 1: remove from queue
            int curr = q.poll();

            if (!visited[curr]) {
                // step 2: if not visited, add to ans and mark as visited
                elements.add(curr);
                visited[curr] = true;

                // step 3: add neighbours
                for (int i = 0; i<graph[curr].size(); i++) {
                    int neighbour = graph[curr].get(i).dest;
                    q.add(neighbour);
                }
            }
        }

        return elements;
    }

    public static void dfs(List<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i<graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, vis, i);
            }
        }
    }

    public static void dfsUtil(List<Edge>[] graph, boolean[] visited, int curr) {
        // step 1: print current node, or add to ans list
        System.out.println(curr);

        // step 2: mark current node as visited
        visited[curr] = true;

        // step 3: iterate on neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;

            // step 4: recursively call the same if neighbour isn't visited 
            if (!visited[neighbour]) {
                dfsUtil(graph, visited, neighbour);
            }
        }
    }

    public static boolean hasPath(List<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            // base case: if current node is destination
            return true;
        }
        
        // step 1: mark current node as visited
        visited[src] = true;

        // step 2: iterate (DFS) on neighbouring nodes
        for (int i = 0; i<graph[src].size(); i++) {
            int neighbour = graph[src].get(i).dest;
            
            // step 3: if neighbour is visited, check if neighbour knows the path
            if (!visited[neighbour] && hasPath(graph, neighbour, dest, visited)) {
                // return true to previous recursional call in case neighbour returned true
                return true;
            }
        }

        // neighbour never returned a path
        return false;
    }

    public static void main(String[] args) {
        List<Edge>[] graph = construct();
        // dfs(graph);
        // System.out.println(bfs(graph));
        // System.out.println(hasPath(graph, 0, 5, new boolean[graph.length]));
    }
}