package medium.dynamicProgramming;

import static java.lang.Math.max;

/**
 * 01背包
 *
 * <p>物品i，重wi，价值vi，背包承重mw，怎么装价值最高
 *
 * @author by liangzj
 * @since 2022/10/16 22:43
 */
public class ZeroOneKnapsackV2Main {

    static int[] goods = new int[] {0, 1, 2, 3, 4};
    static int[] w = new int[] {0, 4, 3, 2, 5};
    static int[] v = new int[] {0, 5, 4, 3, 8};

    static int capacity = 8;
    static int[][] dp = new int[goods.length][capacity + 1];

    public static void main(String[] args) {

        maxPick(capacity, dp);
        //        pick(goods.length - 1, capacity);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 获取
     *
     * @param capacity
     * @param dp
     */
    private static void maxPick(int capacity, int[][] dp) {
        for (int i = 1; i < goods.length; i++) {
            for (int remainWeight = 1; remainWeight <= capacity; remainWeight++) {
                if (w[i] > remainWeight) {
                    dp[i][remainWeight] = dp[i - 1][remainWeight];
                } else {
                    dp[i][remainWeight] =
                            max(dp[i - 1][remainWeight], dp[i - 1][remainWeight - w[i]] + v[i]);
                }
            }
        }
    }

    /**
     * 挑拣商品
     *
     * @param i 第i件商品
     * @param remainWeight 剩余容量
     * @return 物品价值
     */
    private static Integer pick(int i, int remainWeight) {
        if (i == 0) {
            return 0;
        }

        if (remainWeight >= w[i]) {
            dp[i][remainWeight] =
                    max(pick(i - 1, remainWeight), pick(i - 1, remainWeight - w[i]) + v[i]);
        } else {
            dp[i][remainWeight] = pick(i - 1, remainWeight);
        }

        return dp[i][remainWeight];
    }
}
