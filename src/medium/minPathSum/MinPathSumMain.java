package medium.minPathSum;
/**
 * 64. 最小路径和
 *
 * @since 2023/6/14 23:09
 * @author by liangzj
 */
public class MinPathSumMain {
    public static void main(String[] args) {}

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int preMin;
                if (row == 0 && col == 0) preMin = 0;
                else if (row == 0) preMin = dp[row][col - 1];
                else if (col == 0) preMin = dp[row - 1][col];
                else preMin = Math.min(dp[row - 1][col], dp[row][col - 1]);

                dp[row][col] = preMin + grid[row][col];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
