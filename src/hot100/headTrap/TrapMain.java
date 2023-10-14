package hot100.headTrap;

import java.util.Arrays;

/**
 * 42. 接雨水
 *
 * @since 2023/10/10 21:06
 * @author by liangzj
 */
public class TrapMain {
    public static void main(String[] args) {
        System.out.println(trap2(new int[] {2, 0, 2}));
    }

    /** 按照行来计算 (超时) */
    public static int trap(int[] height) {
        int maxH = Arrays.stream(height).max().orElse(0);

        boolean start;
        int rowCount, res = 0;
        for (int h = 1; h <= maxH; h++) {
            start = false;
            rowCount = 0;
            for (int i : height) {
                if (i >= h) {
                    if (start) {
                        res += rowCount;
                        rowCount = 0;
                    } else {
                        start = true;
                    }
                } else if (start) {
                    rowCount++;
                }
            }
        }

        return res;
    }

    /** 按列计算 */
    public static int trap2(int[] height) {
        if (height.length <= 2) return 0;

        int maxN = height.length, sum = 0, tempSum, min;

        // 获取当前柱子右边的最大高度
        int[] rightMaxH = new int[maxN];
        rightMaxH[maxN - 2] = height[maxN - 1];
        for (int n = maxN - 3; n >= 0; n--) {
            rightMaxH[n] = Math.max(height[n + 1], rightMaxH[n + 1]);
        }

        for (int left = 0; left < maxN; left++) {
            if (height[left] == 0 || rightMaxH[left] == 0) continue;

            tempSum = 0;
            min = Math.min(height[left], rightMaxH[left]);
            for (int right = left + 1; right < maxN; right++) {
                if (height[right] >= min) {
                    sum += tempSum;
                    left = right - 1;
                    break;
                } else {
                    tempSum += (min - height[right]);
                }
            }
        }

        return sum;
    }
}
