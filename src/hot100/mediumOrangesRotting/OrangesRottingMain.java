package hot100.mediumOrangesRotting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @since 2024/8/9 下午3:00
 * @author by liangzj
 */
public class OrangesRottingMain {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // 统计新鲜橘子数量，记录当前腐烂橘子
        int fresh = 0;
        Queue<int[]> rotQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotQueue.offer(new int[] {i, j});
                }
            }
        }

        // 按照轮次进行橘子的腐化
        int round = 0;
        while (fresh > 0 && !rotQueue.isEmpty()) {
            round++;
            int curRotSize = rotQueue.size();

            // 腐化周围橘子
            for (int i = 0; i < curRotSize; i++) {
                int[] rotOrange = rotQueue.poll();

                // 检查四个方向是否有可以腐化的橘子
                for (int[] direction : directions) {
                    int row = rotOrange[0] + direction[0];
                    int col = rotOrange[1] + direction[1];

                    // 腐化
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        fresh--;
                        grid[row][col] = 2;
                        rotQueue.offer(new int[] {row, col});
                    }
                }
            }
        }

        return fresh == 0 ? round : -1;
    }
}
