package _01±³°üÎÊÌâ;

public class Knapsack04 {
    int[] memo;

    public int kanpsack02(int[] w, int[] v, int c) {
        int n = w.length;
        if (n == 0 || c <= 0) {
            return 0;
        }
        memo = new int[c + 1];
        for (int i = 0; i <= c; i++) {
            memo[i] = (c >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], (v[j] + memo[j - w[i]]));
            }
        }
        return memo[c];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        Knapsack01 K = new Knapsack01();
        int result = K.kanpsack01(w, v, 5);
        System.out.println(result);
    }
}
