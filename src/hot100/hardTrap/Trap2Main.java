package hot100.hardTrap;

/**
 * 42. 接雨水(按列求，优化-动态规划)
 *
 * @since 2023/11/5 7:52
 * @author by liangzj
 */
public class Trap2Main {
    public static void main(String[] args) {}

    public int trap(int[] height) {
        int length = height.length;

        int[] maxLeft = new int[length], maxRight = new int[length];
        maxLeft[0] = height[0];
        maxRight[length - 1] = height[length - 1];

        // 记录左侧最大
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }

        // 记录右边最大
        for (int r = length - 2; r > 0; r--) {
            maxRight[r] = Math.max(height[r + 1], maxRight[r + 1]);
        }

        // 计算面积
        int tempArea, ans = 0;
        for (int i = 1; i < length - 1; i++) {
            tempArea = Math.min(maxLeft[i], maxRight[i]) - height[i];

            ans += Math.max(tempArea, 0);
        }

        return ans;
    }
}
