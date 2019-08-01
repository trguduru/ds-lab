package io.tguduru.ds.lab.crackingcode.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of Graph using adjacency map data structure.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/15/16.
 */
public class Graph<V, E> {

    private class Vertex<V> {
        private V element;
        private Map<Vertex<V>, Edge<E>> incoming, outgoing;

        public Vertex(boolean isDirected, V ele) {
            this.element = ele;
            incoming = new HashMap<>();
            if (isDirected) {
                outgoing = new HashMap<>();
            } else {
                outgoing = incoming;
            }
        }

        public V getElement() {
            return element;
        }

        public Map<Vertex<V>, Edge<E>> getIncoming() {
            return incoming;
        }

        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        public Collection<Edge<E>> getOutgoingEdges() {
            return outgoing.values();
        }
    }

    private class Edge<E> {
        private E element;
        private Vertex<V> origin;
        private Vertex<V> destination;

        public Edge(E element, Vertex<V> origin, Vertex<V> destination) {
            this.element = element;
            this.origin = origin;
            this.destination = destination;
        }

        public E getElement() {
            return element;
        }

        public Vertex<V> getOrigin() {
            return origin;
        }

        public Vertex<V> getDestination() {
            return destination;
        }
    }

    private boolean isDirected;
    private Map<V, Vertex<V>> vertices;
    private List<Edge<E>> edges;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        vertices = new HashMap<V, Vertex<V>>();
        edges = new ArrayList<>();
    }

    private Edge<E> getEdge(Vertex<V> ori, Vertex<V> dest) {
        return ori.getOutgoing().get(dest);
    }

    public void insertVertex(V ele) {
        Vertex<V> vertex = new Vertex<>(true, ele);
        vertices.put(ele, vertex);
    }

    public Vertex<V> find(V ele) {
        return vertices.get(ele);
    }

    public Edge<E> findEdge(V ele1, V ele2) {
        Vertex<V> vertex1 = find(ele1);
        Vertex<V> vertex2 = find(ele2);
        if (vertex1 == null || vertex2 == null) {
            throw new RuntimeException("Cannot find vertices");
        }
        return getEdge(vertex1, vertex2);

    }

    public Edge<E> insertEdge(V v1, V v2, E ele) {
        Vertex<V> ori = find(v1);
        Vertex<V> dest = find(v2);
        if (getEdge(ori, dest) == null) {
            Edge<E> edge = new Edge<>(ele, ori, dest);
            ori.getOutgoing().put(dest, edge);
            dest.getIncoming().put(ori, edge);
            edges.add(edge);
            return edge;
        } else {
            System.err.println("Edge already existed");
            return null;
        }
    }

    public void depthFirstSearch(V ele) {
        Vertex<V> vertex = find(ele);
        if (vertex == null) {
            System.err.println("Cannot find the vertex :" + ele);
            return;
        }
        List<Vertex<V>> vertices = new ArrayList<>();
        Map<Vertex<V>, Edge<E>> edgeMap = new HashMap<>();
        dfs(vertex, vertices, edgeMap);
        vertices.forEach(a -> System.out.print(a.getElement() + " -->"));
    }

    public void breadthFirstSearch(V ele) {
        Vertex<V> vertex = find(ele);
        if (vertex == null) {
            System.err.println("Cannot find vertex : " + ele);
            return;
        }
        List<Vertex<V>> vertices = new ArrayList<>();
        Map<Vertex<V>, Edge<E>> edgeMap = new HashMap<>();
        bfs(vertex, vertices, edgeMap);
        vertices.forEach(a -> System.out.print(a.getElement() + " --> "));
    }

    private void bfs(Vertex<V> vertex, List<Vertex<V>> vertices, Map<Vertex<V>, Edge<E>> edgeMap) {
        vertices.add(vertex);
        List<Vertex<V>> v = new ArrayList<>();
        v.add(vertex);
        while (!v.isEmpty()) {
            List<Vertex<V>> levels = new ArrayList<>();
            for (Vertex<V> temp : v) {
                temp.getOutgoingEdges().stream().filter(edge -> !vertices.contains(edge.getDestination())).forEach(edge -> {
                    vertices.add(edge.getDestination());
                    edgeMap.put(edge.destination, edge);
                    levels.add(edge.getDestination());
                });
            }
            v = levels;
        }
    }

    /**
     * Implements the DFS algorithm
     */
    private void dfs(Vertex<V> vertex, List<Vertex<V>> visited, Map<Vertex<V>, Edge<E>> paths) {
        visited.add(vertex);
        for (Edge<E> edge : vertex.getOutgoingEdges()) {
            Vertex<V> temp = edge.getDestination();
            if (!visited.contains(temp)) {
                paths.put(temp, edge);
                dfs(temp, visited, paths);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer, Integer> graph = new Graph<>(true);
        graph.insertVertex(10);
        graph.insertVertex(20);
        graph.insertVertex(30);
        graph.insertVertex(40);
        graph.insertVertex(50);
        graph.insertVertex(60);
        graph.insertVertex(70);
        graph.insertEdge(10, 20, 10); // 10 edge value
        graph.insertEdge(10, 20, 40); // should throw an error saying edge already existed
        graph.insertEdge(10, 30, 20);
        graph.insertEdge(10, 40, 30);
        graph.insertEdge(20, 30, 10);
        graph.insertEdge(20, 40, 20);
        graph.insertEdge(30, 40, 10);
        graph.insertEdge(30, 50, 55);
        graph.insertEdge(40, 60, 100);
        graph.insertEdge(20, 70, 110);
        graph.insertEdge(60, 70, 120);
        graph.insertEdge(70, 50, 130);
        System.out.println(graph.findEdge(10, 20).getElement()); // returns 10 as edge value
        System.out.println(graph.edges.size());
        System.out.println(graph.vertices.size());
        System.out.println(graph.find(30).getIncoming().size());
        System.out.println("Depth First Search");
        graph.depthFirstSearch(10);
        System.out.println();
        graph.depthFirstSearch(30);
        System.out.println();
        graph.depthFirstSearch(45);
        System.out.println("Breadth First Search");
        graph.breadthFirstSearch(10);
    }
}
