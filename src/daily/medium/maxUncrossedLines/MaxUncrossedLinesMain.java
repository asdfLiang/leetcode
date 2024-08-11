package daily.medium.maxUncrossedLines;

/**
 * 1035. 不相交的线
 *
 * @since 2024/8/11 下午11:50
 * @author by liangzj
 */
public class MaxUncrossedLinesMain {
    public static void main(String[] args) {
        MaxUncrossedLinesMain obj = new MaxUncrossedLinesMain();

        System.out.println(obj.maxUncrossedLines(new int[] {1, 4, 2}, new int[] {1, 2, 4}));
    }

    /**
     * 1. dp[i][j] 表示连接nums1[0:i]、nums2[0:j]的最大连线数
     * 2. dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])           (nums1[i - 1] != nums2[j - 1])
     *             = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + 1);  (nums1[i - 1] == nums2[j - 1])
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
