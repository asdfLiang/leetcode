package medium.lengthOfLongestSubstring;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串（时间超限-窗口）
 *
 * @since 2023/7/4 23:38
 * @author by liangzj
 */
public class LengthOfLongestSubstringMain {
    public static void main(String[] args) {
        LengthOfLongestSubstringMain obj = new LengthOfLongestSubstringMain();
        System.out.println(obj.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int length = s.length();

        int left = 0;
        int range = s.length() - 1;
        int right = left + range;

        HashSet<Character> set = new HashSet<>(s.length() * 2);

        while (right < length && range > 0) {
            boolean repeat = false;
            for (int i = left; i <= right; i++) {
                repeat = !set.add(s.charAt(i));
                if (repeat) break;
            }

            if (!repeat) {
                return right - left + 1;
            }

            if (right < length - 1) { // 没移到最右边，窗口右移
                left++;
                right++;
            } else if (right == length - 1) { // 窗口缩小，从头开始
                left = 0;
                range--;
                right = left + range;
            }
            set.clear();
        }

        return 1;
    }
}
