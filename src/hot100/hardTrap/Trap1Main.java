package hot100.hardTrap;

/**
 * 42. 接雨水(按列求，暴力解法)
 *
 * @since 2023/11/5 7:52
 * @author by liangzj
 */
public class Trap1Main {
    public static void main(String[] args) {}

    public int trap(int[] height) {
        int length = height.length, maxLeft, maxRight, tempArea, ans = 0;
        for (int i = 1; i < length; i++) {
            // 向左找到最高
            maxLeft = findMax(height, i - 1, -1);

            // 向右找到最高
            maxRight = findMax(height, i + 1, 1);

            // 当前柱的可能面积
            tempArea = Math.min(maxLeft, maxRight) - height[i];

            // 计算面积
            ans += Math.max(tempArea, 0);
        }

        return ans;
    }

    private int findMax(int[] height, int i, int step) {
        int max = 0;

        while (i >= 0 && i < height.length) {
            max = Math.max(height[i], max);
            i += step;
        }

        return max;
    }
}
