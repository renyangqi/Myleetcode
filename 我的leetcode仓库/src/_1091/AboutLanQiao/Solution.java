package _1091.AboutLanQiao;

import java.util.*;

//二维数组中 1是障碍物 0代表可走的路 打印左上到右下的最短路
public class Solution {
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] pre;
    static int Row;
    static int Col;
    static boolean[][] visited;
    static String str = "       ";

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0, 0}
        };
        Row = arr.length;
        Col = arr[0].length;
        visited = new boolean[Row][Col];
        pre = new int[Row * Col];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(oneDimensional(0, 0));
        while (!queue.isEmpty()) {
            Integer cur = queue.remove();
            int x = twoDimensional(cur)[0];
            int y = twoDimensional(cur)[1];
            for (int i = 0; i < dir.length; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && arr[newX][newY] == 0) {
                    queue.add(oneDimensional(newX, newY));
                    visited[newX][newY] = true;
                    pre[oneDimensional(newX, newY)] = cur;
                }
            }
            if (x == Row - 1 && y == Col - 1) {
                break;
            }
        }
        List<Integer> list = getPath();

        for (int i = 0; i < list.size(); i++) {
            int v = list.get(i);
            System.out.print("{" + twoDimensional(v)[0] + "," + twoDimensional(v)[1] + "}");
        }

        for (int i = 1; i < list.size(); i++) {
            str += strPath(list.get(i - 1), list.get(i));
        }
        System.out.println("\n" + str);
    }

    private static String strPath(Integer integer1, Integer integer2) {
        int x1 = twoDimensional(integer1)[0];
        int y1 = twoDimensional(integer1)[1];
        int x2 = twoDimensional(integer2)[0];
        int y2 = twoDimensional(integer2)[1];
        if (x2 - x1 == 0 && y2 - y1 == 1) {
            return "R    ";
        } else if (x2 - x1 == 1 && y2 - y1 == 0) {
            return "D    ";
        } else if (x2 - x1 == 0 && y2 - y1 == -1) {
            return "L    ";
        } else {
            return "U    ";
        }

    }

    private static List<Integer> getPath() {
        ArrayList<Integer> ret = new ArrayList<>();
        int cur = Row * Col - 1;
        while (cur != 0) {
            ret.add(cur);
            cur = pre[cur];
        }
        ret.add(0);
        Collections.reverse(ret);
        return ret;
    }


    public static int[] twoDimensional(int v) {
        return new int[]{v / Col, v % Col};
    }

    public static int oneDimensional(int x, int y) {
        return x * Col + y;
    }

    public static boolean inArea(int x, int y) {
        return x >= 0 && x < Row && y >= 0 && y < Col;
    }
}
