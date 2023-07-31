package medium.checkInclusion;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 *
 * @since 2023/7/31 21:55
 * @author by liangzj
 */
public class CheckInclusionMain {
    public static void main(String[] args) {}

    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();

        if (s1len > s2len) return false;

        int[] s1chars = new int[26];
        int[] s2chars = new int[26];

        for (int i = 0; i < s1len; i++) {
            ++s1chars[s1.charAt(i) - 'a'];
            ++s2chars[s2.charAt(i) - 'a'];
        }

        if (Arrays.equals(s1chars, s2chars)) return true;

        for (int i = s1len; i < s2len; i++) {
            --s2chars[s2.charAt(i - s1len) - 'a'];
            ++s2chars[s2.charAt(i) - 'a'];

            if (Arrays.equals(s1chars, s2chars)) return true;
        }

        return false;
    }
}
