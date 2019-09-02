package _0695;

class Solution4 {
    public int maxAreaOfIsland(int[][] grid) {
        //遍历找到全部1
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int max = 0;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int t = DFS(grid, row, col, i, j);
                    if (t > max) {
                        max = t;
                    }
                }
            }
        }
        return max;
    }

    public int DFS(int[][] grid, int row, int col, int x, int y) {
        //需要返回一个1的个数
        if (x < 0 || x >= row
                || y < 0 || y >= col
                || grid[x][y] != 1) {
            return 0;
        }
        //精髓啊 dfs过程中清-1
        grid[x][y] = -1;
        return 1 + DFS(grid, row, col, x + 1, y)
                + DFS(grid, row, col, x, y + 1)
                + DFS(grid, row, col, x - 1, y)
                + DFS(grid, row, col, x, y - 1);
    }
}