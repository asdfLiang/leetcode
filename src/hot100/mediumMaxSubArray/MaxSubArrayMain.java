package hot100.mediumMaxSubArray;

/**
 * 53. 最大子数组和(动态规划)
 *
 * @since 2023/9/15 20:43
 * @author by liangzj
 */
public class MaxSubArrayMain {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        int[] maxSum = new int[len];
        maxSum[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            int sum = maxSum[i - 1] + nums[i];
            maxSum[i] = Math.max(sum, nums[i]);
            ans = Math.max(maxSum[i], ans);
        }

        return ans;
    }
}
