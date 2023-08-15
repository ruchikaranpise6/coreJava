package algoritham.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
Auxiliary Space: O(V)
*/
public class Graph {

    LinkedList<Integer>[] adj;

    int vertexes;

    Graph(int vertexes) {
        this.vertexes = vertexes;
        adj = new LinkedList[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v1, int v2) {
        adj[v1].add(v2);
    }

    void bfsForConnectedNodes(int startVertex) {
        boolean[] visited = new boolean[vertexes];

        LinkedList<Integer> queue
                = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int recentlyVisitedVertex = queue.peek();
            System.out.print(" " + recentlyVisitedVertex);
            queue.poll();
            if (!adj[recentlyVisitedVertex].isEmpty()) {

                adj[recentlyVisitedVertex].stream().filter(v -> !visited[v]).forEach(v -> {
                    visited[v] = true;
                    queue.add(v);
                });
            }

        }

    }

    void bfsForDisconnectedNodes() {
        boolean[] visited = new boolean[vertexes];
        ArrayList<Integer> bfs_traversal = new ArrayList<>();

        for (int i = 0; i < vertexes; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.add(i);
                System.out.println();
                while (!q.isEmpty()) {
                    int recentlyVisitedVertex = q.peek();
                    q.poll();
                    bfs_traversal.add(recentlyVisitedVertex); // result
                    System.out.println(recentlyVisitedVertex + " ");
                    for (int j = 0; j < adj[recentlyVisitedVertex].toArray().length; j++) {
                        int currentVertex = adj[recentlyVisitedVertex].get(j);

                        if (!visited[currentVertex]) {
                            visited[currentVertex] = true;
                            q.add(currentVertex);
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.bfsForConnectedNodes(2);

        g.bfsForDisconnectedNodes();
    }
}
