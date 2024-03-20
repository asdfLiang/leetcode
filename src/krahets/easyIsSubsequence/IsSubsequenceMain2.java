package krahets.easyIsSubsequence;

/**
 * 392. 判断子序列(双指针)
 *
 * @since 2024/3/20 17:21
 * @author by liangzj
 */
public class IsSubsequenceMain2 {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int sp = 0, tp = 0;

        while (sp < sLen && tp < tLen) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }

            tp++;
        }

        return sp == sLen;
    }
}
