package hot100.mediumSpiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @since 2023/9/25 21:39
 * @author by liangzj
 */
public class SpiralOrderMain {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));

        int[][] matrix1 = new int[][] {{1, 2, 3}};
        System.out.println(spiralOrder(matrix1));

        int[][] matrix2 = new int[][] {{1}};
        System.out.println(spiralOrder(matrix2));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length;

        boolean[][] marks = new boolean[rLen][cLen];

        int row = 0, col = 0;
        List<Integer> ans = new ArrayList<>();
        while (!marks[row][col] || (col + 1 < cLen && !marks[row][col + 1])) {
            if (marks[row][col]) ++col;

            // 向右
            while (col < cLen && !marks[row][col]) {
                marks[row][col] = true;
                ans.add(matrix[row][col++]);
            }
            if (--col < 0 || ++row > rLen) break;

            // 向下
            while (row < rLen && !marks[row][col]) {
                marks[row][col] = true;
                ans.add(matrix[row++][col]);
            }
            if (--row < 0 || --col < 0) break;

            // 向左
            while (col >= 0 && !marks[row][col]) {
                marks[row][col] = true;
                ans.add(matrix[row][col--]);
            }
            if (++col > cLen || --row < 0) break;

            // 向上
            while (col >= 0 && !marks[row][col]) {
                marks[row][col] = true;
                ans.add(matrix[row--][col]);
            }
            if (++row > rLen) break;
        }

        return ans;
    }
}
