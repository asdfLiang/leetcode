package medium.dynamicProgramming;

/**
 * 62. 不同路径
 *
 * @author by liangzj
 * @since 2022/10/18 23:21
 */
public class UniquePathsMain {
    public static void main(String[] args) {
        //
        int m = 3;
        int n = 7;

        int num = uniquePaths(3, 7);
        int num2 = uniquePaths(3, 3);
        System.out.println(num);
        System.out.println(num2);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
