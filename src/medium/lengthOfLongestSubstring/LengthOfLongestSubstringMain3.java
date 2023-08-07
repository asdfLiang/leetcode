package medium.lengthOfLongestSubstring;

import java.util.*;

/**
 * 3. 无重复字符的最长子串（答案）
 * 
 * @since 2023/7/30 9:57
 * @author by liangzj
 */
public class LengthOfLongestSubstringMain3 {
    public static void main(String[] args) {}

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        occ.add(s.charAt(0));
        for (int i = 1; i < n; ++i) {
            // 左指针向右移动一格，移除一个字符
            occ.remove(s.charAt(i - 1));

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
