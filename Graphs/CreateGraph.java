package Graphs;

import java.util.*;;

public class CreateGraph {

    public static List<Edge>[] construct() {
        int vertices = 5;

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 4));

        // vertex 1
        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 2, 2));
        graph[1].add(new Edge(1, 3, 8));
        graph[1].add(new Edge(1, 4, -3));

        // vertex 2
        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 6));

        // vertex 3
        graph[3].add(new Edge(3, 2, 6));
        graph[3].add(new Edge(3, 1, 8));

        // vertex 4
        graph[4].add(new Edge(4, 1, -3));

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
        List<Integer> elements = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (!visited[curr]) {
                elements.add(curr);
                visited[curr] = true;

                // add neighbours
                List<Integer> neighbours = getNeighbours(curr, graph);
                for (int neighbour : neighbours) {
                    q.add(neighbour);
                }
            }
        }

        return elements;
    }

    public static void dfs(List<Edge>[] graph, boolean[] visited, int curr) {
        System.out.println(curr);
        visited[curr] = true;


        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;
            if (!visited[neighbour]) {
                dfs(graph, visited, neighbour);
            }
        }
    }

    public static boolean hasPath(List<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int i = 0; i<graph[src].size(); i++) {
            int neighbour = graph[src].get(i).dest;
            
            if (!visited[neighbour] && hasPath(graph, neighbour, dest, visited)) {
                return true;
            } else {
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Edge>[] graph = construct();
        System.out.println(hasPath(graph, 0, 5, new boolean[graph.length]));
    }
}