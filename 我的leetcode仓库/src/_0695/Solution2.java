package _0695;
//为每一个连通分量标号 计算每个标号的长度
public class Solution2 {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] graph;
    private boolean[][] visited;

    private int[][] ccNum;
    private int ccid = 1;

    private int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        graph = grid;
        visited = new boolean[graph.length][graph[0].length];
        ccNum = new int[graph.length][graph[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, ccid);
                    ccid++;
                }
            }
        }
        printCCNUM();
        max = getMax();
        return max;
    }

    private int getMax() {
        int[] arr = new int[ccid];
        for (int i = 0; i < ccNum.length; i++) {
            for (int j = 0; j < ccNum[0].length; j++) {
                int v = ccNum[i][j];
                if (v != 0) {
                    arr[v]++;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private void printCCNUM() {
        for (int[] ints : ccNum) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private void dfs(int x, int y, int ccid) {
        visited[x][y] = true;
        ccNum[x][y] = ccid;
        for (int i = 0; i < 4; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && graph[newx][newy] == 1) {
                dfs(newx, newy, ccid);
            }
        }

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x <= graph.length - 1 && y >= 0 && y <= graph[0].length - 1;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        Solution2 s = new Solution2();
        int res = s.maxAreaOfIsland(graph);
        System.out.println(res);
    }
}
