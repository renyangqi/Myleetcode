package _0079;

class Solution {
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
        if (index == word.length() - 1 && !visited[startx][starty])
            return board[startx][starty] == word.charAt(index);
        if (board[startx][starty] == word.charAt(index) && !visited[startx][starty]) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];

                if (inArea(newx, newy) ) {
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

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        Solution solution = new Solution();
        boolean exist = solution.exist(board, "ABCCED");
        System.out.println(exist);
    }
}