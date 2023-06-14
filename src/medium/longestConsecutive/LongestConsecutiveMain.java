package medium.longestConsecutive;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @since 2023/6/12 22:47
 * @author by liangzj
 */
public class LongestConsecutiveMain {
    public static void main(String[] args) {
        int[] nums = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        // 放入set，O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : nums) {
            // 有比num小的，说明num不是序列的第一个数，跳过
            if (set.contains(num - 1)) continue;

            // 到这里说明num是序列的第一个数，计算从num开始的最长连续序列
            max = Math.max(max, countConsecutive(num, set));
        }

        return max;
    }

    private static int countConsecutive(int start, Set<Integer> set) {
        int count = 1;

        while (set.contains(start + 1)) {
            ++count;
            ++start;
        }

        return count;
    }
}
