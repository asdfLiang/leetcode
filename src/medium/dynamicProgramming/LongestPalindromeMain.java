package medium.dynamicProgramming;

/**
 * 最长回文子串，暴力解法
 *
 * @author by liangzj
 * @since 2022/10/14 18:01
 */
public class LongestPalindromeMain {

    public static void main(String[] args) {
        //
        String s = "babad";
        String s1 = "cbbd";
        String s2 = "aacabdkacaa";
        String s3 =
                "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";

        System.out.println(longestPalindrome(s3));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() > 1000) {
            return s;
        }

        String result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {

            int matchIdx = s.length() - 1;
            while (matchIdx > i) {
                // 不相等则一直减，直到找到相等的
                while (matchIdx > i && s.charAt(i) != s.charAt(matchIdx)) {
                    matchIdx--;
                }

                // 判断区间内是否回文子串
                if (matchIdx > i && isPalindrome(s, i, matchIdx)) {
                    if (matchIdx + 1 - i > result.length()) {
                        result = s.substring(i, matchIdx + 1);
                    }
                }
                matchIdx--;
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }

        if ((end - start <= 1) && s.charAt(start) == s.charAt(end)) {
            return true;
        }

        return false;
    }
}
