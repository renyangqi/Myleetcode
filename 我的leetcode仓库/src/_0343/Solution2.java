package _0343;

import java.sql.SQLOutput;
import java.util.Arrays;

//使用动态规划
public class Solution2 {
    public int integerBreak(int n) {
        //memo[n]对n进行分割(至少分割成两部分)返回的最大乘积
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            //分割i j+ (i-j)
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = Math.max(memo[i],Math.max(j*(i-j),j * memo[i - j]) );
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int num = new Solution2().integerBreak(10);
        System.out.println(num);
    }
}
