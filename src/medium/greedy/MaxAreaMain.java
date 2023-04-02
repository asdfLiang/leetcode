package medium.greedy;

/**
 * 11. 盛最多水的容器
 *
 * @author by liangzj
 * @since 2022/10/23 9:40
 */
public class MaxAreaMain {
    public static void main(String[] args) {
        //
        int[] height1 = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea3(height1);
        System.out.println(maxArea);
    }

    public static int maxArea3(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                res = Math.max(res, (end - start) * height[start++]);
            } else {
                res = Math.max(res, (end - start) * height[end--]);
            }
        }

        return res;
    }

    public static int maxArea2(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for (int start = 0; start < len; start++) {
            for (int end = start + 1; end < len; end++) {
                int curArea = (end - start) * Math.min(height[start], height[end]);
                maxArea = Math.max(curArea, maxArea);
            }
        }

        return maxArea;
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        // 最近最高
        int latestEnd;
        // 所有墙总高
        int totalSkip;
        // 最近内墙总高
        int latestSkip;
        for (int start = 0; start < len; start++) {
            latestEnd = 0;
            latestSkip = 0;
            totalSkip = 0;
            for (int end = start + 1; end < len; end++) {
                // 当前高度高于最近高度
                if (height[end] > latestEnd) {
                    latestEnd = end;
                    latestSkip = totalSkip;
                }

                totalSkip += height[end];
            }

            // 当前高度=最远跨度 * 最高高度 - 区间内墙总高
            int curArea =
                    (height[latestEnd] - height[start]) * Math.min(height[start], height[latestEnd])
                            - latestSkip;
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }
}
