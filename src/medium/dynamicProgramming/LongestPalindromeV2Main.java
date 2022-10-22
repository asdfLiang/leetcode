package medium.dynamicProgramming;

/**
 * 最长回文子串，动态规划
 *
 * @author by liangzj
 * @since 2022/10/14 18:01
 */
public class LongestPalindromeV2Main {

    public static void main(String[] args) {
        //
        String s = "babad";
        String s1 = "cbbd";
        String s2 = "aacabdkacaa";
        String s3 =
                "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";

        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));
    }

    public static String longestPalindrome(String s) {
        int maxLen = s.length();
        if (maxLen < 1 || maxLen > 1000) {
            return s;
        }

        boolean[][] dp = new boolean[maxLen][maxLen];

        String result = s.substring(0, 1);
        for (int end = 1; end < maxLen; end++) {
            for (int start = 0; start < end; start++) {
                // 记录子串是否是回文子串
                if (s.charAt(end) == s.charAt(start)) {
                    // 两端相等，且小于3个数，一定是回文数
                    if (end - start < 3) {
                        dp[start][end] = true;
                        // 两端相等，且大于3个数，判断中间的是不是回文数
                    } else if (dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                    }
                } else {
                    // 两端不相等一定不是回文
                    dp[start][end] = false;
                }

                // 记录最长的
                if (dp[start][end] && (end - start + 1) > result.length()) {
                    result = s.substring(start, end + 1);
                }
            }
        }

        return result;
    }
}
