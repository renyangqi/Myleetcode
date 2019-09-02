package _0200;

class Solution {
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//右 下 左 上
    int m, n;
    boolean[][] visited;
    int res = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    //在grid[x][y] 寻找与当前陆地连接的陆地
    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (isArea(newx, newy) && grid[newx][newy] == '1' && !visited[newx][newy]) {
                dfs(grid, newx, newy);
            }
        }
    }

    private boolean isArea(int newx, int newy) {
        boolean ret = newx >= 0 && newx < m && newy >= 0 && newy < n;
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int result = s.numIslands(grid);
        System.out.println(result);
    }
}
