package medium.uniquePathsWithObstacles;
/**
 * 63. 不同路径 II
 *
 * @since 2023/6/14 23:57
 * @author by liangzj
 */
public class UniquePathsWithObstaclesMain {
    public static void main(String[] args) {}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 矩阵为空
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        // 开始或结束位置有障碍物
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int col = 1; col < cols; col++) {
            dp[0][col] = (obstacleGrid[0][col] == 0 && dp[0][col - 1] == 1) ? 1 : 0;
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = (obstacleGrid[row][0] == 0 && dp[row - 1][0] == 1) ? 1 : 0;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (obstacleGrid[row][col] == 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                } else {
                    dp[row][col] = 0;
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
