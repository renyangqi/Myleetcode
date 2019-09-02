package _01±³°üÎÊÌâ;

public class Knapsack03 {
    int[][] memo;

    public int kanpsack03(int[] w, int[] v, int c) {

        int n = w.length;
        if (n == 0 || c == 0)
            return 0;
        memo = new int[2][c + 1];
        for (int i = 0; i <= c; i++) {
            memo[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i%2][j] = memo[(i - 1)%2][j];
                if (j >= w[i]) {
                    memo[i%2][j] = Math.max(memo[i%2][j], v[i] + memo[(i - 1)%2][j - w[i]]);
                }
            }
        }
        return memo[(n-1) % 2][c];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        Knapsack01 K = new Knapsack01();
        int result = K.kanpsack01(w, v, 5);
        System.out.println(result);
    }
}
