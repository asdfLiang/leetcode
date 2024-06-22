package hot100.mediumCanPartition;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 *
 * @since 2024/6/22 上午11:45
 * @author by liangzj
 */
public class CanPartitionMain {

    public static void main(String[] args) {
        CanPartitionMain obj = new CanPartitionMain();

        System.out.println(obj.canPartition(new int[] {1, 2, 5}));
    }

    /**
     * 1. dp[i] 表示容量为i时的最大价值
     * 2. dp[i] = max(dp[j], dp[j - nums[i]] + nums[i]);
     * 3. dp[0 ~ nums.length] = 0;
     * 4. 外层正序，内层逆序
     */
    public boolean canPartition(int[] nums) {

        // 获取目标值
        int target = sum(nums);
        if (target % 2 != 0) return false;
        target /= 2;

        // dp数组
        int[] dp = new int[target + 1];

        // 物品i
        for (int i = 0; i < nums.length; i++) {
            // 物品价值
            for (int j = target; j >= 0; j--) {
                // 如果已经和目标值相等，返回true
                if (dp[j] == target || nums[i] == target) {
                    return true;
                } else if (j >= nums[i] && (nums[i] + dp[j - nums[i]]) <= target) { // 记录最接近目标值的数
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        return false;
    }

    private int sum(int[] nums) {
        int target = 0;

        for (int num : nums) target += num;

        return target;
    }
}
