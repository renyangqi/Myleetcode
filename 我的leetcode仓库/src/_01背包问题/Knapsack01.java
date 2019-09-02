package _01背包问题;

/**
 * 准确的讲，背包问题的递推方程应该分如下两种情况讨论：
 * <1> F（i, C）= max{F(i -1, C), F(i - 1, C - w(i)) + v(i)} (当C - w(i) >= 0 ) 或者
 * <2> F(i, C) = F(i -1, C)(当C - w(i) <0)
 * 如果F(i ,C) 表示 恰好把前i 种物品放到C 所获取的最大价值，那就变成了递推方程<1>, 就不用考虑<2>了。
 * 对第<1>个递推方程的准确解释应该是：首先，F(i, C) 表示的意义应该是前 i 种物品放到剩余容量为C 所获取的最大价值（注：并不是说前i种物品都放进去了，具体是哪几种组合，我们并不知晓）
 * 然后，我们假设已经递归处理了前i -1 种物品，并获取了最大价值；那么对于第i 物品此时有两种选择：要么放，
 * 要么不放（不放并不是指此时容量已经剩余的不多了，而只是一种选择而已），这两种情况都有可能达到最优解，所以我们需要比较，取最大值从而保证 F(i ,C)等于最大价值
 */


/**
 * 重叠子问题
 * w 1 2 3 4 6 6
 * v 1 2 3 4 6 6    c=20
 * <p>
 * 0-5:20
 * /                           \
 * 0-4:20                        0-4:14 +6
 * /       \                        /    \
 * 0-3:20    0-3:14 +6            0-3:14   0-3:8+6
 * 存在重叠子问题
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

    // 索引为[0,index] 的物品放入容量为c的背包里的最大值
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
