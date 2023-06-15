package easy.climbStairs;
/**
 * 70. 爬楼梯
 *
 * @since 2023/6/15 22:22
 * @author by liangzj
 */
public class ClimbStairsMain {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if (n < 1) return 0;
        if (n <= 2) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n - 1];
    }
}
