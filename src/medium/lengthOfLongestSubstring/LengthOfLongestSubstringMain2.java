package medium.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @since 2023/7/30 9:57
 * @author by liangzj
 */
public class LengthOfLongestSubstringMain2 {
    public static void main(String[] args) {}

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int left = 0;
        int length = s.length();
        int longest = 1;

        // Map<char, index>
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            Integer latestIndex = map.get(c);
            if (latestIndex != null) {
                longest = Math.max(i - left, longest);
                left = latestIndex + 1;
                // 删除下标小于left的元素
                Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Character, Integer> next = it.next();
                    if (next.getValue() < left) it.remove();
                }
            } else {
                longest = Math.max(i - left + 1, longest);
            }

            map.put(c, i);
        }

        return longest;
    }
}
