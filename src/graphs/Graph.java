package graphs;

import java.util.*;

public class Graph<T> {

    private List<Edge> edges;
    private Map<Integer, Vertex<T>> vertices;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.edges = new ArrayList<Edge>();
        this.vertices = new HashMap<Integer, Vertex<T>>();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values();
    }

    public void setVertices(Map<Integer, Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public void addEdge(int id1,  int id2, int weight) {
        Vertex vertex1, vertex2;
        if (this.vertices.containsKey(id1)) {
            vertex1 = this.vertices.get(id1);
        } else {
            vertex1 = new Vertex(id1);
            this.vertices.put(id1, vertex1);
        }

        if (this.vertices.containsKey(id2)) {
            vertex2 = this.vertices.get(id2);
        } else {
            vertex2 = new Vertex(id2);
            this.vertices.put(id2, vertex2);
        }

        this.edges.add(new Edge(vertex1, vertex2, weight, this.isDirected));
        vertex1.addAdjacentVertex(vertex2);
        if (!this.isDirected()) {
            vertex2.addAdjacentVertex(vertex1);
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Edge edge : this.edges) {
            buffer.append(edge.getVertex1().getId() + " ---> " + edge.getVertex2().getId() + "\n");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph(true);
        graph.addEdge(1, 2, 0);
        System.out.print(graph.toString());
    }
}

class Edge<T> {

    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;
    private boolean isDirected;

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public void setVertex1(Vertex<T> vertex1) {
        this.vertex1 = vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public void setVertex2(Vertex<T> vertex2) {
        this.vertex2 = vertex2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }
}

class Vertex<T> {

    private int id;
    private T data;
    private List<Vertex<T>> adjacentVertices;

    public Vertex(int id) {
        this.id = id;
        this.data = null;
        this.adjacentVertices = new ArrayList<Vertex<T>>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Vertex<T>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(List<Vertex<T>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<T> vertex) {
        this.adjacentVertices.add(vertex);
    }
}
