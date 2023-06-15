package medium.canJump;
/**
 * 55. 跳跃游戏
 *
 * @since 2023/6/15 22:43
 * @author by liangzj
 */
public class CanJumpMain {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        int farthest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 最远到不了当前位置，直接返回false
            if (farthest < i) return false;
            // 当前位置能到的最远位置
            dp[i] = i + nums[i];
            // 如果当前位置能跳到的位置更远，记录下来
            if (dp[i] > farthest) farthest = dp[i];
        }

        return farthest >= nums.length - 1;
    }
}
