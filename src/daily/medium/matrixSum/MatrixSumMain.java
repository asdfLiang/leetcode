package daily.medium.matrixSum;

import java.util.Arrays;

/**
 * 2679. 矩阵中的和
 *
 * @since 2023/7/4 22:48
 * @author by liangzj
 */
public class MatrixSumMain {
    public static void main(String[] args) {}

    public int matrixSum(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;

        for (int row = 0; row < rows; row++) {
            Arrays.sort(nums[row]);
        }

        int res = 0;
        for (int col = 0; col < cols; col++) {
            int colMax = nums[0][col];
            for (int row = 0; row < rows; row++) {
                colMax = Math.max(nums[row][col], colMax);
            }
            res += colMax;
        }
        return res;
    }
}
