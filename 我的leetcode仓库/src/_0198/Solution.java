package _0198;

import java.util.Arrays;

class Solution {
    //memo[i]表示考虑抢劫nums[i..n)所能获得的最大收益
    int[] memo;
    public int rob(int[] nums) {
        //考虑打劫[index....n)范围的所有房子
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryBob(nums, 0);
    }

    private int tryBob(int[] num, int index) {
        if (index >= num.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < num.length; i++) {
            res = Math.max(res, num[i] + tryBob(num, i + 2));
        }
        memo[index] = res;
        return res;
    }
}