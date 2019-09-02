package _0416;


public class Solution2 {
    boolean[] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int C = sum / 2;
        memo = new boolean[C + 1];
        for (int i = 0; i <=C ; i++) {
            memo[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[C];
    }

}

