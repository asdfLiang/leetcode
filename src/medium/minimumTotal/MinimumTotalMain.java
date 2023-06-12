package medium.minimumTotal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @since 2023/6/12 21:47
 * @author by liangzj
 */
public class MinimumTotalMain {
    public static void main(String[] args) {
        List<List<Integer>> triangle =
                new ArrayList<>() {
                    {
                        add(Collections.singletonList(2));
                        add(Arrays.asList(3, 4));
                        add(Arrays.asList(6, 5, 7));
                        add(Arrays.asList(4, 1, 8, 3));
                    }
                };

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][triangle.get(rows - 1).size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int row = 1; row < rows; row++) {
            int prevRow = row - 1;
            List<Integer> colValues = triangle.get(row);
            int cols = colValues.size();

            for (int col = 0; col < cols; col++) {
                int prevMin;
                if (col == 0) {
                    prevMin = dp[prevRow][0];
                } else if (col == cols - 1) {
                    prevMin = dp[prevRow][col - 1];
                } else {
                    prevMin = Math.min(dp[prevRow][col - 1], dp[prevRow][col]);
                }

                dp[row][col] = prevMin + colValues.get(col);
            }
        }

        int min = dp[rows - 1][0];
        for (int j : dp[rows - 1]) {
            min = Math.min(min, j);
        }

        return min;
    }
}
