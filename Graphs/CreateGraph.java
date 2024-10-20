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
        int vertices = 6;

        // Create an array of lists to represent the adjacency list for the graph
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[vertices];

        // Initialize each list in the array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // unconnected graph
        // graph[0].add(new Edge(0, 1, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[2].add(new Edge(2, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));
        // graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));
        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));

        // Directed Graph (Cyclic)
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // graph[1].add(new Edge(1, 3, 1));
        // graph[2].add(new Edge(2, 3, 1));

        // Directed Graph (DAP)
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 1, 1));
        // graph[4].add(new Edge(4, 1, 1));
        // graph[4].add(new Edge(4, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));
        // graph[5].add(new Edge(5, 0, 1));

        // default graph + cyclic
        // graph[0].add(new Edge(0, 1, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 1));
        // graph[1].add(new Edge(1, 4, 1));
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 2, 1));
        // graph[3].add(new Edge(3, 1, 1));
        // graph[4].add(new Edge(4, 1, 1));

        // Cyclic graph
        // graph[0].add(new Edge(0, 3, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 1, 1));
        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));
        // graph[5].add(new Edge(5, 2, 1));
        // graph[5].add(new Edge(5, 0, 1));

        // weighted graph for Dijkstra
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 3, 2));

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
        boolean[] visited = new boolean[graph.length]; // to mark visited nodes and avoid stucking in cycles
        List<Integer> allElements = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                allElements.addAll(bfsUtil(graph, visited, i));
            }
        }

        return allElements;
    }

    public static List<Integer> bfsUtil(List<Edge>[] graph, boolean[] visited, int first) {
        List<Integer> elements = new ArrayList<>(); // ans list
        Queue<Integer> q = new LinkedList<>(); // queue to process vertices
        q.add(first); // init queue

        while (!q.isEmpty()) {
            // step 1: remove from queue
            int curr = q.poll();

            if (!visited[curr]) {
                // step 2: if not visited, add to ans and mark as visited
                elements.add(curr);
                visited[curr] = true;

                // step 3: add neighbours
                for (int i = 0; i < graph[curr].size(); i++) {
                    int neighbour = graph[curr].get(i).dest;
                    q.add(neighbour);
                }
            }
        }

        return elements;
    }

    public static void dfs(List<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
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
        for (int i = 0; i < graph[src].size(); i++) {
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

    public static boolean isUndirectedGraphCyclic(List<Edge>[] graph) {
        // marks visited nodes
        boolean[] vis = new boolean[graph.length];

        // iterate on all the nodes
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                // process node if not visited
                if (isUndirectedGraphCyclicUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isUndirectedGraphCyclicUtil(List<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true; // mark current as a visited node

        // explore current node neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;

            // when neighbour is not visited, do recursive call for neighbour
            if (!vis[neighbour]) {
                // return true if neighbour got a cycle
                if (isUndirectedGraphCyclicUtil(graph, vis, neighbour, curr)) {
                    return true;
                }

            } else if (vis[neighbour] && neighbour != parent) {
                // neighbour is visited and its not the parent node, means its a cycle
                return true;
            }

            // case 3: continue if neighbour is visited but neighbour is the parent node
        }

        // no cycle detected
        return false;
    }

    public static boolean isBipartite(List<Edge>[] graph) {
        // 0 -> not colored
        // 1 -> colored blue
        // 2 -> colored yellow

        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        // core bfs + some modifications, TC: O(V + E)
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                // init new graph part
                color[i] = 1;
                q.add(i);

                // bfs logic
                while (!q.isEmpty()) {
                    int curr = q.remove();

                    // process neighbours
                    for (int j = 0; j < graph[curr].size(); j++) {
                        int neighbour = graph[curr].get(j).dest;

                        if (color[neighbour] == 0) {
                            // neighbour is not colored ? then color it and add to the queue
                            color[neighbour] = color[curr] == 1 ? 2 : 1;
                            q.add(neighbour);

                        } else if (color[neighbour] != 0 && color[neighbour] == color[curr]) {
                            // neighbour is colored & color is same as the parent, it not bipartite
                            // (curr is parent of neighbour)
                            return false;

                        }
                    }
                }
            }
        }

        // is bipartite
        return true;
    }

    public static boolean isDirectedGraphCyclic(List<Edge>[] graph) {

        boolean[] vis = new boolean[graph.length]; // marks visited nodes globally
        boolean[] visitedInSession = new boolean[graph.length]; // marks visited node per session

        // iterate on all the graph nodes
        for (int i = 0; i < graph.length; i++) {
            // process node only if its NOT visited
            if (!vis[i]) {
                // return true if helper finds a cycle
                if (isDirectedGraphCyclicUtil(i, graph, vis, visitedInSession)) {
                    return true;
                }
            }
        }

        // no cycle detected
        return false;
    }

    public static boolean isDirectedGraphCyclicUtil(
            int curr,
            List<Edge>[] graph,
            boolean[] visitedGlobally,
            boolean[] visitedInSession) {

        visitedGlobally[curr] = true; // mark node as visited in global arr
        visitedInSession[curr] = true; // mark node as visited in current session

        // explore current neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;

            // if the current node is already marked as visited in the current session
            // means its a cycle
            if (visitedInSession[neighbour]) {
                return true;
            }

            // if curr node is not visited in global session,
            // then do recursive call for neighbour, return true if neighbour founds a cycle
            if (!visitedGlobally[neighbour]
                    && isDirectedGraphCyclicUtil(neighbour, graph, visitedGlobally, visitedInSession)) {
                return true;
            }
        }

        visitedInSession[curr] = false; // unmark curr node as visited when backtracking
        return false;
    }

    public static List<Integer> topologicalSortDFS(List<Edge>[] graph) {
        List<Integer> order = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();  // Stack to store the topological order
        boolean[] vis = new boolean[graph.length];  // Visited array to track processed nodes
    
        // Iterate over all nodes in the graph to ensure we handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                // Perform DFS for unvisited nodes
                topologicalSortUtilDFS(i, stk, graph, vis);
            }
        }
    
        // Pop elements from the stack to get the topological order (reverse DFS finish times)
        while (!stk.empty()) {
            order.add(stk.pop());
        }
    
        return order;  // Return the topologically sorted order
    }
    
    public static void topologicalSortUtilDFS(
        int curr,
        Stack<Integer> stk,
        List<Edge>[] graph,
        boolean[] vis
    ) {
        vis[curr] = true;  // Mark the current node as visited
    
        // Explore all the neighbors of the current node
        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i).dest;
    
            // If the neighbor hasn't been visited, recursively call DFS on it
            if (!vis[neighbour]) {
                topologicalSortUtilDFS(neighbour, stk, graph, vis);
            }
        }
    
        // After visiting all neighbors, push the current node to the stack
        // This ensures that the current node is processed only after all its dependencies
        stk.push(curr);
    }
    
    // Kahn's Algorithm
    public static List<Integer> topologicalOrderBFS(List<Edge>[] graph) {
        // step 1: init indegree
        int[] indegree = new int[graph.length];

        // calculate indegree for each vertex
        for (int i = 0; i < graph.length; i++) {
            int curr = i;

            for (int j = 0; j < graph[curr].size(); j++) {
                int dependent = graph[curr].get(j).dest;
                indegree[dependent]++;
            }
        }

        Queue<Integer> q = new LinkedList<>(); // BFS queue
        List<Integer> topologicalList = new ArrayList<>();

        // init queue with 0 indegree nodes
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // core bfs approach
        while (!q.isEmpty()) {
            int curr = q.remove(); // element popped will have indegree of 0
            // means no more nodes are depended on curr, or they are resolved
            topologicalList.add(curr);

            // process neighbours
            for (int i = 0; i < graph[curr].size(); i++) {
                int neighbour = graph[curr].get(i).dest;
                indegree[neighbour]--; // resolve by -1,
                // because neighbour was depended on curr
                // since curr is resolved, dependency on neighbours should be -1

                // if dependency of neighbour is 0, it should be add next to queue
                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return topologicalList;

    }

    public static List<List<Integer>> allPathsToTarget(int src, int target, List<Edge>[] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        allPathsToTargetUtil(
            src, 
            target, 
            graph, 
            new ArrayList<>(), 
            allPaths,
            new boolean[graph.length]
        );

        return allPaths;
    }

    public static void allPathsToTargetUtil(
        int src,
        int target,
        List<Edge>[] graph,
        List<Integer> path,
        List<List<Integer>> allPaths,
        boolean[] vis
    ) {
        path.add(src);
        vis[src] = true;

        if (src == target) {
            allPaths.add(new ArrayList<>(path));

        } else {
            for (int i = 0; i < graph[src].size(); i++) {
                int neighbour = graph[src].get(i).dest;
                if (!vis[neighbour]) {
                    allPathsToTargetUtil(neighbour, target, graph, path, allPaths, vis);
                }
            }
        }

        path.remove(path.size() - 1);
        vis[src] = false;
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int key, int value) {
            this.node = key;
            this.distance = value;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance;
        }
    }

    public static int[] dijkstraAlgo(int src, List<Edge>[] graph) {

        // distance from src to each node
        int[] dist = new int[graph.length];

        // assuming distance to be infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // distance from src to src -> 0

        boolean[] visited = new boolean[graph.length];

        // ensures the node with the min distance is at front
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, dist[src])); // init queue with src

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            // process node only if not visited
            if (!visited[curr.node]) {
                visited[curr.node] = true;

                // process neighbours
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge edge = graph[curr.node].get(i);
                    int u = edge.src; // current node
                    int v = edge.dest; // neighbour node
                    int wt = edge.weight; // weight of edge

                    // core dijkstra formula (greedy)
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        List<Edge>[] graph = construct();
        // dfs(graph);
        // System.out.println(bfs(graph));
        // System.out.println(isCyclic(graph));
        // System.out.println(isBipartite(graph));
        // System.out.println(isDirectedGraphCyclic(graph));
        // System.out.println(topologicalSortDFS(graph));
        // System.out.println(topologicalOrderBFS(graph));

        // System.out.println(allPathsToTarget(5, 1, graph));
        int[] dijkstra = dijkstraAlgo(0, graph);

        for (int i = 0; i < dijkstra.length; i++) {
            System.out.println("0 -> " + i + ": " + dijkstra[i]);
        }
    }
}