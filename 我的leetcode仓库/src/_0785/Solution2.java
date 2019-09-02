package _0785;

import java.util.LinkedList;
import java.util.Queue;
//广度优先遍历
public class Solution2 {
    private int[][] graph;
    private boolean[] visited;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int V = graph.length;
        visited = new boolean[V];
        colors = new int[V];

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                if (!bfs(v)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int s) {
        Queue<Integer> x = new LinkedList<>();
        x.add(s);
        visited[s] = true;
        colors[s] = 0;
        while (!x.isEmpty()) {
            int v = x.remove();
            for (int w : graph[v]) {
                if (!visited[w]) {
                    x.add(w);
                    visited[w] = true;
                    colors[w] = 1 - colors[v];
                } else if (colors[w] == colors[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}
