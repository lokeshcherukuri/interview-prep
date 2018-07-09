package graphs;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Traversal {

    public Traversal() {

    }

    public void dfs(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<Integer>();
        Collection<Vertex<Integer>> vertices = graph.getVertices();
        for (Vertex<Integer> vertex : vertices) {
            dfsUtil(vertex, visited);
        }
    }

    private void dfsUtil(Vertex vertex, Set<Integer> visited) {
        if (visited.contains(vertex.getId())) {
            return;
        }

        System.out.print(vertex.getId() + " --> ");
        visited.add(vertex.getId());
        List<Vertex> adjacentVertices = vertex.getAdjacentVertices();
        for (Vertex<Integer> child : adjacentVertices) {
            dfsUtil(child, visited);
        }
    }

    public void bfs(Graph<Integer> graph) {
        Collection<Vertex<Integer>> vertices = graph.getVertices();
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(2, 4, 0);
        graph.addEdge(3, 4, 0);
        graph.addEdge(4, 6, 0);
        graph.addEdge(6, 5, 0);
        graph.addEdge(5, 1, 0);
        graph.addEdge(5,3, 0);

        Traversal t = new Traversal();
        t.dfs(graph);
    }
}
