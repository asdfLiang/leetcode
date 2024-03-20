package krahets.easyIsSubsequence;

/**
 * 392. 判断子序列
 *
 * @since 2024/3/20 17:16
 * @author by liangzj
 */
public class IsSubsequenceMain {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (char c : s.toCharArray()) {
            if ((start = findChar(c, t, start)) == -1) {
                return false;
            }
            ++start;
        }

        return true;
    }

    private int findChar(char c, String t, Integer start) {
        for (int i = start; i < t.length(); i++) {
            if (c == t.charAt(i)) {
                return i;
            }
        }

        return -1;
    }
}
