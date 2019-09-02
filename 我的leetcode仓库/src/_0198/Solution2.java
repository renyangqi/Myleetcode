package _0198;

import java.util.Arrays;

public class Solution2 {
    //memo[i]表示偷取[i...n-1]内房子产生的最大值
    int[] memo;

    public int rob(int[] nums) {
        //考虑打劫[index....n-1]范围的所有房子
        int n = nums.length;
        if(n==0){
            return 0;
        }
        memo = new int[nums.length];

        memo[n - 1] = nums[n - 1];
        int res = 0;
        for (int i = n - 2; i >= 0; i--) {
            //memo[i]
            for (int j = i; j < n; j++) {
                res = Math.max(res, nums[j] + (j + 2< n ? memo[j + 2] : 0));
            }
            memo[i] = res;
        }
        System.out.println(memo[0]);
        return memo[0];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int rob = s.rob(new int[]{1, 2, 3, 1});

    }
}
