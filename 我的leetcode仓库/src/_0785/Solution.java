package _0785;

import java.util.ArrayList;
//使用深度优先遍历
class Solution {
    private int[] colors;
    private boolean[] visited;
    private boolean isBipartite = true;

    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, 0)) {
                    isBipartite = false;
                    break;
                }
            }
        }
        return isBipartite;
    }

    private boolean dfs(int[][] graph, int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : graph[v]) {
            if (!visited[w]) {
                if (!dfs(graph, w, 1 - color)) {
                    return false;
                }
            } else if (colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         *           0      3
         *          / \
         *         1  2
         */
        boolean bipartite = solution.isBipartite(new int[][]{{}});
        System.out.println(bipartite);
    }
}