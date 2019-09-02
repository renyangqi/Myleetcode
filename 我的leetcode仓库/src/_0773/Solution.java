package _0773;
// Leetcode 773

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();

        String initalState = boardToString(board);
        if (initalState.equals("123450")) return 0;

        queue.add(initalState);
        visited.put(initalState, 0);
        while (!queue.isEmpty()) {
            String cur = queue.remove();

            ArrayList<String> nexts = getNexts(cur);

            for (String next : nexts)
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if (next.equals("123450"))
                        return visited.get(next);
                }

        }
        return -1;
    }

    private ArrayList<String> getNexts(String s) {
        ArrayList<String> ret = new ArrayList<>();
        int[][] cur = stringToBoard(s);
        int zero;
        for (zero = 0; zero < s.length(); zero++) {
            if (s.charAt(zero) == '0') {
                break;
            }
        }

        int zeroX = zero / 3, zeroY = zero % 3;
        for (int d = 0; d < 4; d++) {
            int nextX = zeroX + dir[d][0];
            int nextY = zeroY + dir[d][1];
            if (inArea(nextX, nextY)) {
                swap(cur, zeroX, zeroY, nextX, nextY);
                ret.add(boardToString(cur));
                swap(cur, zeroX, zeroY, nextX, nextY);
            }
        }
        return ret;
    }

    private void swap(int[][] cur, int zeroX, int zeroY, int nextX, int nextY) {
        int t = cur[zeroX][zeroY];
        cur[zeroX][zeroY] = cur[nextX][nextY];
        cur[nextX][nextY] = t;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                sb.append(board[i][j]);
        return sb.toString();
    }

    private int[][] stringToBoard(String s) {
        int[][] ret = new int[2][3];
        for (int i = 0; i < s.length(); i++) {
            ret[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = solution.slidingPuzzle(new int[][]{
                {4, 1, 2},
                {5, 0, 3}});
        System.out.println(x);
    }
}
