package Graphs;

import java.util.*;

public class ConnectingCitiesWithMinCost {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int source, int destination, int weight) {
            this.src = source;
            this.dest = destination;
            this.wt = weight;
        }
    }

    static class Info implements Comparable<Info> {
        int vertice;
        int cost;

        public Info(int vertices, int cost) {
            this.cost = cost;
            this.vertice = vertices;
        }

        @Override
        public int compareTo(Info other) {
            return this.cost - other.cost;
        }
    }

    public static List<Edge>[] createGraphs(int[][] matrix, int vertices) {
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    graph[i].add(new Edge(i, j, matrix[i][j]));
                }
            }
        }

        return graph;
    }

    public static int connectingCities(int[][] flights) {
        int n = flights.length;
        List<Edge>[] graph = createGraphs(flights, n);
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        int cost = 0;

        pq.add(new Info(0, 0));

        while (!pq.isEmpty()) {
            Info curr = pq.remove();

            if (!visited[curr.vertice]) {
                visited[curr.vertice] = true;

                cost += curr.cost;

                for (int i = 0; i < graph[curr.vertice].size(); i++) {
                    Edge e = graph[curr.vertice].get(i);
                    pq.add(new Info(e.dest, e.wt));
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        int[][] cities = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };

        System.out.println(connectingCities(cities));
    }
}
