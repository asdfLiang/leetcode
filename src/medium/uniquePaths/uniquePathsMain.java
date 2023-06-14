package medium.uniquePaths;
/**
 * 62. 不同路径
 *
 * @since 2023/6/14 23:38
 * @author by liangzj
 */
public class uniquePathsMain {

    public static void main(String[] args) {}

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) dp[row][col] = 1;
                else dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
