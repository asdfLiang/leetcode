package medium.findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @since 2023/7/30 9:44
 * @author by liangzj
 */
public class FindAnagramsMain {
    public static void main(String[] args) {}

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) return new ArrayList<>();

        int length = 0;
        int[] sCharNums = new int[26];
        int[] pCharNums = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCharNums[s.charAt(i) - 'a'];
            ++pCharNums[p.charAt(i) - 'a'];
        }

        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(sCharNums, pCharNums)) result.add(0);

        for (int sSubEnd = pLen; sSubEnd < sLen; sSubEnd++) {
            --sCharNums[s.charAt(sSubEnd - pLen) - 'a'];
            ++sCharNums[s.charAt(sSubEnd) - 'a'];

            if (Arrays.equals(sCharNums, pCharNums)) result.add(sSubEnd - pLen + 1);
        }

        return result;
    }
}
