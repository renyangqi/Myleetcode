package _0695;

public class Solution {
    //右下左上
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] graph;
    private boolean[][] visited;
    private int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        graph = grid;
        visited = new boolean[graph.length][graph[0].length];
        //第几个连通分量
        int ccnum = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    //返回每一个连通分量的面积
                    int v = dfs(i, j);
                    System.out.println("第" + ccnum + "个连通分量的面积为：" + v);
                    ccnum++;
                    max = Math.max(v, max);
                }
            }
        }
        return max;
    }

    //函数定义：计算从graph[x][y]这个点开始
    // 求四个方向没有访问过,并且值是1的点的个数
    private int dfs(int x, int y) {
        //我的代码递归终止条件是隐式的。
        // 因为递归进入的点本身是1，所以ret 赋值为1;
        //如果元件递归到底了,也就是上下左右没有值为1的点，或者是1但是之前访问过了。
        //那么下面的for循环中的if条件不会成立,因此不会改变ret的值。
        //如果没有递归到底,当前的ret要加上其他四个方向上，没有访问过,并且值是1的点的个数
        int ret = 1;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            //只有在newx,newy下标合法,且下一个位置没有被访问过,并且下一个位置是1的时候才进行下一次递归
            if (inArea(newx, newy) && !visited[newx][newy] && graph[newx][newy] == 1) {
                ret += dfs(newx, newy);
            }
        }
        return ret;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x <= graph.length - 1 && y >= 0 && y <= graph[0].length - 1;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1}};
        Solution s = new Solution();
        int res = s.maxAreaOfIsland(graph);
        System.out.println("最大面积为" + res);
    }
}

