package _0343;

import java.util.Arrays;
//�ݹ���仯����
class Solution {
    private int[] memo;

    //���ؽ����n�ָ�� ���ܻ�õ� �ָ���ÿһ���ֳ˻������ֵ
    public int integerBreak(int n) {
        memo = new int[n + 1];//�Դ���ʮ memo[10] һ��11������
        Arrays.fill(memo, -1);
        return breakInteger(n);

    }

    //��n���зָ�(�ָ������2����)�������ĳ˻�
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
