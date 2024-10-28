package Graphs;
import java.util.*;

public class TarjanBridgeProblem {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(List<Edge>[] graph) {
        for (int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    static int time = 0;

    public static void tarjanBridge(
        List<Edge>[] graph,
        int curr,
        int par,
        int[] dt,
        int[] ldt,
        boolean[] vis
    ) {

        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;

        for (int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if (neighbour == par) {
                continue;
            
            } else if (!vis[neighbour]) {
                tarjanBridge(
                    graph, 
                    neighbour, 
                    curr, 
                    dt, 
                    ldt, 
                    vis
                );

                ldt[curr] = Math.min(ldt[curr], ldt[neighbour]);

                if (dt[curr] < ldt[neighbour]) {
                    System.out.println("Bridge: " + curr + " -> " + neighbour);
                }

            } else if (vis[neighbour]) {
                ldt[curr] = Math.min(ldt[curr], dt[neighbour]); 

            }

        }

    }

    public static void main(String[] args) {
        int V = 5;
        
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int[] discoveryTime = new int[V];
        int[] lowestDiscoveryTime = new int[V];
        boolean[] visited = new boolean[V];

        tarjanBridge(
            graph, 
            0, 
            -1, 
            discoveryTime, 
            lowestDiscoveryTime, 
            visited
        );
    }
}
