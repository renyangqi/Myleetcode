package _01��������;

/**
 * ׼ȷ�Ľ�����������ĵ��Ʒ���Ӧ�÷���������������ۣ�
 * <1> F��i, C��= max{F(i -1, C), F(i - 1, C - w(i)) + v(i)} (��C - w(i) >= 0 ) ����
 * <2> F(i, C) = F(i -1, C)(��C - w(i) <0)
 * ���F(i ,C) ��ʾ ǡ�ð�ǰi ����Ʒ�ŵ�C ����ȡ������ֵ���Ǿͱ���˵��Ʒ���<1>, �Ͳ��ÿ���<2>�ˡ�
 * �Ե�<1>�����Ʒ��̵�׼ȷ����Ӧ���ǣ����ȣ�F(i, C) ��ʾ������Ӧ����ǰ i ����Ʒ�ŵ�ʣ������ΪC ����ȡ������ֵ��ע��������˵ǰi����Ʒ���Ž�ȥ�ˣ��������ļ�����ϣ����ǲ���֪����
 * Ȼ�����Ǽ����Ѿ��ݹ鴦����ǰi -1 ����Ʒ������ȡ������ֵ����ô���ڵ�i ��Ʒ��ʱ������ѡ��Ҫô�ţ�
 * Ҫô���ţ����Ų�����ָ��ʱ�����Ѿ�ʣ��Ĳ����ˣ���ֻ��һ��ѡ����ѣ���������������п��ܴﵽ���Ž⣬����������Ҫ�Ƚϣ�ȡ���ֵ�Ӷ���֤ F(i ,C)��������ֵ
 */


/**
 * �ص�������
 * w 1 2 3 4 6 6
 * v 1 2 3 4 6 6    c=20
 * <p>
 * 0-5:20
 * /                           \
 * 0-4:20                        0-4:14 +6
 * /       \                        /    \
 * 0-3:20    0-3:14 +6            0-3:14   0-3:8+6
 * �����ص�������
 */
public class Knapsack01 {
    int[][] memo;

    public int kanpsack01(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w, v, n - 1, c);
    }

    // ����Ϊ[0,index] ����Ʒ��������Ϊc�ı���������ֵ
    public int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, bestValue(w, v, index - 1, c - w[index]) + v[index]);
        }
        memo[index][c] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] w = new int[]{3, 2, 1};
        int[] v = new int[]{12, 10, 6};
        Knapsack01 K = new Knapsack01();
        int result = K.kanpsack01(w, v, 5);
        System.out.println(result);
    }
}
