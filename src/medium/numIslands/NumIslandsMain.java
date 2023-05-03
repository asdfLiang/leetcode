package medium.numIslands;
/**
 * 200. 岛屿数量
 *
 * @since 2023/5/3 20:18
 * @author by liangzj
 */
public class NumIslandsMain {
    public static void main(String[] args) {
        NumIslandsMain obj = new NumIslandsMain();

        char[][] grid =
                new char[][] {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
                };

        System.out.println(obj.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandNum = 0;
        boolean[][] mark = new boolean[nr][nc];
        for (int row = 0; row < nr; row++) {
            for (int col = 0; col < nc; col++) {
                if (grid[row][col] == '1' && !mark[row][col]) {
                    dfsArea(grid, mark, row, col);
                    islandNum++;
                }
            }
        }

        return islandNum;
    }

    /** 标记遍历过的格子 */
    public void dfsArea(char[][] grid, boolean[][] mark, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;
        // 超过图的范围
        if (row < 0 || row >= nr || col < 0 || col >= nc) {
            return;
        }

        // 已遍历过或当前格子是海洋
        if (mark[row][col] || grid[row][col] == '0') {
            return;
        }

        // 标记当前格子
        mark[row][col] = true;

        // 当前格子的四个方向都遍历一遍
        dfsArea(grid, mark, row - 1, col);
        dfsArea(grid, mark, row + 1, col);
        dfsArea(grid, mark, row, col - 1);
        dfsArea(grid, mark, row, col + 1);
    }
}
