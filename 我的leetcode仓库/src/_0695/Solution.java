package _0695;

public class Solution {
    //��������
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] graph;
    private boolean[][] visited;
    private int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        graph = grid;
        visited = new boolean[graph.length][graph[0].length];
        //�ڼ�����ͨ����
        int ccnum = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    //����ÿһ����ͨ���������
                    int v = dfs(i, j);
                    System.out.println("��" + ccnum + "����ͨ���������Ϊ��" + v);
                    ccnum++;
                    max = Math.max(v, max);
                }
            }
        }
        return max;
    }

    //�������壺�����graph[x][y]����㿪ʼ
    // ���ĸ�����û�з��ʹ�,����ֵ��1�ĵ�ĸ���
    private int dfs(int x, int y) {
        //�ҵĴ���ݹ���ֹ��������ʽ�ġ�
        // ��Ϊ�ݹ����ĵ㱾����1������ret ��ֵΪ1;
        //���Ԫ���ݹ鵽����,Ҳ������������û��ֵΪ1�ĵ㣬������1����֮ǰ���ʹ��ˡ�
        //��ô�����forѭ���е�if�����������,��˲���ı�ret��ֵ��
        //���û�еݹ鵽��,��ǰ��retҪ���������ĸ������ϣ�û�з��ʹ�,����ֵ��1�ĵ�ĸ���
        int ret = 1;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            //ֻ����newx,newy�±�Ϸ�,����һ��λ��û�б����ʹ�,������һ��λ����1��ʱ��Ž�����һ�εݹ�
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
        System.out.println("������Ϊ" + res);
    }
}

