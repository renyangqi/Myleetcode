package _0695;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.TreeSet;

public class Solution3 {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //����������
    private int R;
    private int C;
    private boolean[] visited;
    private TreeSet<Integer>[] graph;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        R = grid.length;
        if (R == 0) {
            return 0;
        }
        C = grid[0].length;
        if (C == 0) {
            return 0;
        }
        visited = new boolean[R * C];
        graph = constructGraph(grid);
        int max = 0;
        for (int v = 0; v < graph.length; v++) {
            int x = v / C;
            int y = v % C;
            if (!visited[v] && grid[x][y] == 1) {
                // ע��grid[x][y] == 1�������
                // ���grid[x][y]==0 ���ݹ鷵��һ��1
                //��Ϊ�ݹ��ȥ�ǽ�����grid[x][y]��1����������� һ��ʼret = 1
                int num = dfs(v);
                max = Math.max(max, num);
            }
        }
        return max;
    }

    private int dfs(int v) {
        visited[v] = true;
        int ret = 1;
        for (int w : graph[v]) {
            if (!visited[w]) {
                ret += dfs(w);
            }
        }
        return ret;
    }

    private TreeSet<Integer>[] constructGraph(int[][] grid) {
        TreeSet<Integer>[] ret = new TreeSet[R * C];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = new TreeSet<Integer>();
        }
        for (int v = 0; v < ret.length; v++) {
            int x = v / C;
            int y = v % C;
            if (grid[x][y] == 1) {
                for (int i = 0; i < 4; i++) {
                    int nextx = x + dirs[i][0];
                    int nexty = y + dirs[i][1];
                    if (inArea(nextx, nexty) && grid[nextx][nexty] == 1) {
                        int w = nextx * C + nexty;
                        ret[v].add(w);
                    }
                }
            }
        }
        return ret;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        Solution3 s = new Solution3();
        int res = s.maxAreaOfIsland(graph);
        System.out.println(res);
    }
}
