package hot100.hardMaxSlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * @since 2025/6/26 21:58
 * @author by liangzj9624
 */
public class MaxSlidingWindowMain {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.offer(i);
        }
        ans[0] = nums[list.getFirst()];

        for (int i = k; i < n; i++) {
            if (list.getLast() <= i - k) {
                list.poll();
            }

            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            list.offer(i);

            ans[i - k + 1] = nums[list.getFirst()];
        }

        return ans;
    }
}
