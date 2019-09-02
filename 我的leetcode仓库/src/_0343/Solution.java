package _0343;

import java.util.Arrays;
//递归记忆化搜索
class Solution {
    private int[] memo;

    //返回将这个n分割后 所能获得的 分割中每一部分乘积的最大值
    public int integerBreak(int n) {
        memo = new int[n + 1];//对传入十 memo[10] 一共11个数字
        Arrays.fill(memo, -1);
        return breakInteger(n);

    }

    //将n进行分割(分割成至少2部分)返回最大的乘积
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Max3(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int Max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int num = new Solution().integerBreak(10);
        System.out.println(num);
    }
}
