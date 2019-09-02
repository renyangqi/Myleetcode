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
        //从边界开始dfs找到所有与边界的0连接的点设置成#号
        //这样把非#的0变成x,把#变成0 就可以了
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
