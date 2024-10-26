package Graphs;

import java.util.*;

public class KruskalAlgo {
    static int n = 4;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static List<Edge> createGraph() {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(2, 3, 50));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(0, 3, 30));
        return edges;
    }

    public static int find(int a) {
        if (a == par[a]) {
            return a;
        }

        return par[a] = find(par[a]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;

        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;

        } else {
            par[parB] = parA;
        }
    }

    public static int minimumSpanningTree(List<Edge> graph) {
        Collections.sort(graph);
        int cost = 0;
        int count = 0;

        for (int i = 0; count < n - 1; i++) {
            Edge e = graph.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA == parB) {
                continue;
            }

            cost += e.wt;
            union(e.src, e.dest);
            count++;
        }

        return cost;
    }

    public static void main(String[] args) {
        init();
        List<Edge> graph = createGraph();
        System.out.println(minimumSpanningTree(graph));
    }
}
