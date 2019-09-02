package _0070;

/**
 * n = 3
 * 1 1 1
 * 1 2
 * 2 1
 * <p>
 * n = 4          0     1     2
 * 1 1 1 1 SUM= C 4 + C 3  + C 2
 * 2 1 1                                                0
 * 1 2 1    ���� ����0��2 Ҳ����ȫ��ֻ��һ��ʱ ����� C n = 1  ���߷�
 * 1 1 2    ÿ������һ����2��ʱ��Ҳ����ÿ��һ��2���ܲ�������1��
 * 2 2                     1
 * ����һ��2 �� һ���� C n-1 �����
 * <p>                    2
 * ��������2 ��  һ����C n-2 �����
 * <p>
 * ��˴���n   ����� n/2 = k �� 2 �ĳ���
 *                          0      1               k     k��n/2 ȡ��
 * ���Խ��Ϊ   result = C n + C n-1 + .......  C n-k
 * ����ǵ��͵��������
 *    4    6*5*4*3
 * C 6 = ������������
 *        1*2*3*4
 */
class Solution {
    public int climbStairs(int n) {
        int k = n / 2;
        int result = 0;
        //            0      1               k     k��n/2 ȡ��
        //result = C n + C n-1 + .......  C n-k
        for (int i = 0; i <= k; i++) {
            System.out.print("n= " + (n - i) + " k=" + i + "  ");
            int x = combination(n - i, i);
            result = result + x;
        }
        return result;
    }
    //�����                                  k
    private int combination(int n, int k) { //C n
        long res = 1;//ע��ʹ��long���� ��int����ֵ�ܴ�ʱ�����
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        System.out.println(res);
        return (int)res;
    }

    public static void main(String[] args) {
        int sum = new Solution().climbStairs(44);
        System.out.println("һ����"+sum+"���߷�");
    }
}
