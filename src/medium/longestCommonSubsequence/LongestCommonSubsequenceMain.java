package medium.longestCommonSubsequence;
/**
 * 1143. 最长公共子序列（看过解析）
 *
 * @since 2023/6/28 1:44
 * @author by liangzj
 */
public class LongestCommonSubsequenceMain {
    public static void main(String[] args) {}

    public int longestCommonSubsequence(String text1, String text2) {
        int text1Len = text1.length();
        int text2Len = text2.length();
        int[][] dp = new int[text1Len + 1][text2Len + 1];

        for (int i = 1; i <= text1Len; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2Len; j++) {
                char c2 = text2.charAt(j - 1);

                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1Len][text2Len];
    }
}
