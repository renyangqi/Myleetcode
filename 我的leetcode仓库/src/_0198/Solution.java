package _0198;

import java.util.Arrays;

class Solution {
    //memo[i]��ʾ��������nums[i..n)���ܻ�õ��������
    int[] memo;
    public int rob(int[] nums) {
        //���Ǵ��[index....n)��Χ�����з���
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