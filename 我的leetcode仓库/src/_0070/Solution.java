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
 * 1 2 1    解释 当有0个2 也就是全部只走一部时 有组合 C n = 1  中走法
 * 1 1 2    每当出现一次走2步时，也就是每多一个2，总步数减少1次
 * 2 2                     1
 * 出现一次2 ， 一共有 C n-1 种情况
 * <p>                    2
 * 出现两次2 ，  一共有C n-2 种情况
 * <p>
 * 因此传入n   最多有 n/2 = k 次 2 的出现
 *                          0      1               k     k是n/2 取整
 * 所以结果为   result = C n + C n-1 + .......  C n-k
 * 因此是典型的组合问题
 *    4    6*5*4*3
 * C 6 = ——————
 *        1*2*3*4
 */
class Solution {
    public int climbStairs(int n) {
        int k = n / 2;
        int result = 0;
        //            0      1               k     k是n/2 取整
        //result = C n + C n-1 + .......  C n-k
        for (int i = 0; i <= k; i++) {
            System.out.print("n= " + (n - i) + " k=" + i + "  ");
            int x = combination(n - i, i);
            result = result + x;
        }
        return result;
    }
    //求组和                                  k
    private int combination(int n, int k) { //C n
        long res = 1;//注意使用long类型 用int当数值很大时会溢出
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        System.out.println(res);
        return (int)res;
    }

    public static void main(String[] args) {
        int sum = new Solution().climbStairs(44);
        System.out.println("一共有"+sum+"种走法");
    }
}
