package Graphs;

import java.util.*;

public class CheapestFlightWithKStops {

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

    static class Info {
        int vertice;
        int cost;
        int stops;

        public Info(int vertices, int cost, int stops) {
            this.cost = cost;
            this.vertice = vertices;
            this.stops = stops;
        }
    }

    public static List<Edge>[] createGraphs(int[][] flights, int airports) {

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[airports];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int cost = flight[2];

            graph[source].add(new Edge(source, destination, cost));
        }

        return graph;
    }

    public static int cheapestFlight(int[][] flights, int src, int dest, int airports, int k) {
        List<Edge>[] graph = createGraphs(flights, airports);
        Queue<Info> q = new LinkedList<>();

        int[] distance = new int[airports];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.vertice].size(); i++) {
                Edge e = graph[curr.vertice].get(i);
                int u = e.src;
                int v = e.dest;
                int cost = e.wt;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + cost < distance[v] && curr.stops <= k) {
                    distance[v] = cost + distance[u];
                    q.add(new Info(v, distance[v], curr.stops + 1));
                }
            }
        }

        return distance[dest] != Integer.MAX_VALUE ? distance[dest] : -1;
    }

    public static void main(String[] args) {
        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 }
            };

        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(flights, src, dest, 4, k));
    }
}
