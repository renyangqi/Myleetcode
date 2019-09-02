package _0300;

import java.util.Arrays;

class Solution {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //memo[n]表示nums[0...n]的最长上升子序列的长度
        memo = new int[n + 1];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int res = -1;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int result = solution.lengthOfLIS(arr);
        System.out.println(result);
    }
}