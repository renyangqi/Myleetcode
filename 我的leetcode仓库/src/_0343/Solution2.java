package _0343;

import java.sql.SQLOutput;
import java.util.Arrays;

//ʹ�ö�̬�滮
public class Solution2 {
    public int integerBreak(int n) {
        //memo[n]��n���зָ�(���ٷָ��������)���ص����˻�
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            //�ָ�i j+ (i-j)
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
