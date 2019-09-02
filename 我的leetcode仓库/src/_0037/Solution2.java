package _0037;

class Solution2 {
    boolean[][] row;//row[i][j] 判断第i行 有没有j这个数字
    boolean[][] col;
    boolean[][] block;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    row[i][c - '0'] = true;
                    col[j][c - '0'] = true;
                    int bolckIndex = i / 3 * 3 + j / 3;
                    block[bolckIndex][c - '0'] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);//深度优先遍历
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int level, int i) {

        while (board[level][i] != '.') {
            i++;
            if (i >= 9) {
                i = 0;
                level++;
            }
            if (level == 9) {
                for (char[] chars : board) {
                    for (char c : chars) {
                        System.out.print(c+" ");
                    }
                    System.out.println();
                }
                System.out.println("————————————————————");
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int bolckIndex = level / 3 * 3 + i / 3;
            if (!row[level][num] && !col[i][num] && !block[bolckIndex][num]) {
                board[level][i] = (char) ('0' + num);
                row[level][num] = true;
                col[i][num] = true;
                block[bolckIndex][num] = true;
                if (dfs(board, row, col, block, level, i)) {
                    return true;
                } else {
                    //回溯
                    row[level][num] = false;
                    col[i][num] = false;
                    block[bolckIndex][num] = false;
                    board[level][i] = '.';

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
        new Solution2().solveSudoku(board);
    }
}