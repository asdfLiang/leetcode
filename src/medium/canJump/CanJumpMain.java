package medium.canJump;
/**
 * 55. 跳跃游戏
 *
 * @since 2023/6/15 22:43
 * @author by liangzj
 */
public class CanJumpMain {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        int farthest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 最远到不了当前位置，直接返回false
            if (farthest < i) return false;
            // 当前位置能到的最远位置
            dp[i] = i + nums[i];
            // 如果当前跳到位置能到的位置更远，记录下来
            if (dp[i] > farthest) farthest = dp[i];
        }

        return farthest >= nums.length - 1;
    }
}
