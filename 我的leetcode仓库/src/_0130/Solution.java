package _0130;

public class Solution {
    private char[][] board;
    private int row;
    private int col;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        this.board = board;
        row = board.length;
        col = board[0].length;
        //�ӱ߽翪ʼdfs�ҵ�������߽��0���ӵĵ����ó�#��
        //�����ѷ�#��0���x,��#���0 �Ϳ�����
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isBoundary = (i == 0 || i == row - 1 || j == 0 || j == col - 1);
                if (isBoundary) {
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] == 'X' || board[x][y] == '#') {
            return;
        }
        board[x][y] = '#';
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x - 1, y);
    }
}
