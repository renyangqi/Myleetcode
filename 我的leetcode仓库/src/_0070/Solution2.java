package _0070;

import java.util.Arrays;

public class Solution2 {
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcuWays(n);
    }

    private int calcuWays(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (memo[n] == -1) {
            memo[n] = calcuWays(n - 1) + calcuWays(n - 2);
        }
        return memo[n];
    }
}
