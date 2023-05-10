package hard.largestRectangleArea;
/**
 * 84. 柱状图中最大的矩形
 *
 * @since 2023/5/10 23:15
 * @author by liangzj
 */
public class LargestRectangleAreaMain {
    public static void main(String[] args) {
        LargestRectangleAreaMain obj = new LargestRectangleAreaMain();

        System.out.println(obj.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {

        int largestArea = heights[0];

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int weight = 1 + weight(height, heights, i - 1, -1) + weight(height, heights, i + 1, 1);
            int area = height * weight;

            largestArea = Math.max(largestArea, area);
        }

        return largestArea;
    }

    /**
     * 获取宽度
     *
     * @param height 当前柱高度
     * @param heights 所有柱高度
     * @param current 当前下标
     * @param step 比较方向，-1向左比较，1向右比较
     * @return
     */
    public int weight(int height, int[] heights, int current, int step) {

        if (current < 0 || current >= heights.length || heights[current] < height) {
            return 0;
        }

        return 1 + weight(height, heights, current + step, step);
    }
}
