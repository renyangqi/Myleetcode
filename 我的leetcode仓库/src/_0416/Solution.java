package _0416;

import java.util.Arrays;

class Solution {
    // memo[index][c] ��ʾ��nums[0....index]�ܷ���ȫ��������Ϊc�ı���
    // -1��ʾû����,0��ʾ����,1��ʾ��
    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        memo = new int[n][sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum/2+1; j++) {
                memo[i][j] = -1;
            }
        }
        return tyrPartion(nums, n - 1, sum / 2);
    }

    // �ݹ麯���������� ��nums[0...index]����Ʒ�ܷ���ȫ��������Ϊsum�ı�����
    private boolean tyrPartion(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index < 0) {
            return false;
        }
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        memo[index][sum] = ((tyrPartion(nums, index - 1, sum) || tyrPartion(nums, index - 1, sum - nums[index])) == true ? 1 : 0);
        return memo[index][sum] == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,5,11,5};
        boolean res = solution.canPartition(arr);
        System.out.println(res);
    }
}