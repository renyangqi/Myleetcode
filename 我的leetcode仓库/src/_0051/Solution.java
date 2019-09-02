package _0051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> row = new ArrayList<Integer>();
        putQueen(n, 0, row);
        return res;
    }

    // ������һ��n�ʺ�������, �ڷŵ�index�еĻʺ�λ��
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(makeGraph(n, row));
            return;
        }
        //����ÿһ��
        for (int i = 0; i < n; i++) {
            // ���Խ���index�еĻʺ�ڷ��ڵ�i��
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = true;
                dia1[i + index] = true;
                dia2[index - i + n - 1] = true;
                row.add(i);
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[i + index] = false;
                dia2[index - i + n - 1] = false;
                row.remove(new Integer(i));
            }

        }
        return;

    }

    private List<String> makeGraph(int n, List<Integer> row) {
        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }
    private static void printBoard(List<String> board){
        for(String s: board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
    }
}