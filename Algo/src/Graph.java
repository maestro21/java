import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private Map<Vertex, List<Vertex>> adjMap;

    public Graph() {
        this.adjMap = new HashMap<>();
    }

    public void addVertex(String label) {
        adjMap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjMap.values().forEach(list -> list.remove(v));
        adjMap.remove(v);
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjMap.get(v1).add(v2);
        adjMap.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> ev1 = adjMap.get(v1);
        List<Vertex> ev2 = adjMap.get(v2);
        if (ev1 != null) {
            ev1.remove(v2);
        }
        if (ev2 != null) {
            ev2.remove(v1);
        }
    }

    public Set<Vertex> depthFirstSearch(Vertex root) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vert = stack.pop();
            if (!visited.contains(vert)) {
                visited.add(vert);
                adjMap.get(vert).forEach(stack::push);
            }
        }
        return visited;
    }




    public List<Vertex> breadthFirstSearch(Vertex root, Vertex dest) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Vertex vert = queue.poll();
            for (Vertex v : adjMap.get(vert)) {


                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                    v.setPrev(vert);

                    if(v.equals(dest)) {
                        Stack<Vertex> stack = new Stack<>();
                        Vertex curr = v;
                        // restore shortest way
                        while(curr != null && !curr.equals(root)) {
                            stack.push(curr);
                            curr = curr.getPrev();
                        }
                        stack.push(root);

                        List<Vertex> result = new ArrayList<>();
                        while (!stack.isEmpty()) {
                            result.add(stack.pop());
                        }

                        return result;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Maria");
        graph.addVertex("Rob");
        graph.addVertex("Denis");
        graph.addVertex("Diana");
        graph.addVertex("Alberto");
        graph.addVertex("Ignat");
        graph.addVertex("Kate");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Mark", "Maria");
        graph.addEdge("Rob", "Maria");

        graph.addEdge("Maria", "Ignat");
        graph.addEdge("Bob", "Alberto");
        graph.addEdge("Alberto", "Diana");
        graph.addEdge("Diana", "Ignat");
        graph.addEdge("Diana", "Kate");
        graph.addEdge("Ignat", "Kate");

        System.out.println(graph.depthFirstSearch(new Vertex("Bob")));
        System.out.println(graph.breadthFirstSearch(new Vertex("Bob"), new Vertex("Kate")));
    }
}
