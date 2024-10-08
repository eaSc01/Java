package Heaps;

public class Driver {
    static class Node implements Comparable<Node> {
        int a;
        public Node(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            return this.a - o.a;
        }

        
    }
    public static void main(String[] args) {
        MinHeap<Node> heap = new MinHeap<>();

        heap.add(new Node(4));
        heap.add(new Node(8));
        heap.add(new Node(1));
        heap.add(new Node(3));
        heap.add(new Node(6));

        while (!heap.isEmpty()) {
            System.out.println(heap.peek().a);
            heap.remove();
        }
    }
}
