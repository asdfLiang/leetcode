package hot100.mediumMergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @since 2023/9/18 20:16
 * @author by liangzj
 */
public class MergeIntervalsMain {
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][] {{1, 5}, {4, 5}})));
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(inter -> inter[0]));

        int left, right;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            for (int j = i + 1; j < len; j++) {
                if (right >= intervals[j][0]) {
                    right = Math.max(intervals[j][1], right);
                    i = j;
                } else {
                    i = j - 1;
                    break;
                }
            }
            ans.add(new int[] {left, right});
            if (i == len - 1) break;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
