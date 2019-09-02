package _0079;

class Solution2 {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    //从board[startx][starty]开始寻找word[index...last] 每次递归寻找一个字符
    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1)
            return board[startx][starty] == word.charAt(index);
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];

                if (inArea(newx, newy) && visited[newx][newy] == false) {
                    if (searchWord(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }

        return false;
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }


}