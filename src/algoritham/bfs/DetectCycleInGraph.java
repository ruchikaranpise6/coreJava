package algoritham.bfs;

/* In this article, the BFS based solution is discussed. We do a BFS traversal of the given graph.
For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not a parent of v,
then there is a cycle in the graph.
If we don’t find such an adjacent for any vertex, we say that there is no cycle.
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInGraph {
    int vertexes;
    LinkedList<Integer>[] adj;

    DetectCycleInGraph(int vertexes) {
        this.vertexes = vertexes;
        adj = new LinkedList[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v1, int v2) {
        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    boolean isCyclicConnected(int startNode) {
        boolean[] visited = new boolean[vertexes];
        int[] parent = new int[vertexes];
        Queue<Integer> queue = new LinkedList();
        Arrays.fill(parent, -1);

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int recentlyVisitedVertex = queue.poll();
            for (int i = 0; i < adj[recentlyVisitedVertex].size(); i++) {
                int currentVertex = adj[recentlyVisitedVertex].get(0);
                if (!visited[currentVertex]) {
                    visited[currentVertex] = true;
                    queue.add(currentVertex);
                    parent[currentVertex] = recentlyVisitedVertex;
                } else if (parent[recentlyVisitedVertex] != currentVertex) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DetectCycleInGraph g = new DetectCycleInGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        if (g.isCyclicConnected(2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
