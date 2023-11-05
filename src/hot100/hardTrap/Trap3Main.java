package hot100.hardTrap;

/**
 * 42. 接雨水(按列求，优化-动态规划，减少循环)
 *
 * @since 2023/11/5 7:52
 * @author by liangzj
 */
public class Trap3Main {
    public static void main(String[] args) {}

    public int trap(int[] height) {
        int length = height.length;

        int[] maxRight = new int[length];
        maxRight[length - 1] = height[length - 1];

        // 记录右边最大
        for (int r = length - 2; r > 0; r--) {
            maxRight[r] = Math.max(height[r + 1], maxRight[r + 1]);
        }

        // 计算面积
        int maxLeft = height[0], tempArea, ans = 0;
        for (int i = 1; i < length - 1; i++) {
            maxLeft = Math.max(height[i - 1], maxLeft);
            tempArea = Math.min(maxLeft, maxRight[i]) - height[i];

            ans += Math.max(tempArea, 0);
        }

        return ans;
    }
}
