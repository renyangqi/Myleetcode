package _0279;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Pair {
        int n;//到达n这个结点经过了几步
        int step;

        public Pair(int n, int step) {
            this.n = n;
            this.step = step;
        }
    }

    public int numSquares(int n) {

        if (n == 0)
            return 0;

        boolean[] visited = new boolean[n + 1];
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int num = poll.n;
            int step = poll.step;
            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0) {
                        return step + 1;
                    }
                    queue.add(new Pair(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numSquares(12);
        System.out.println(i);
    }
}
