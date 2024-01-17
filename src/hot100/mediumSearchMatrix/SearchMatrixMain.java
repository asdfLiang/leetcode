package hot100.mediumSearchMatrix;

/**
 * 240. 搜索二维矩阵 II
 *
 * @since 2024/1/15 20:51
 * @author by liangzj
 */
public class SearchMatrixMain {
    public static void main(String[] args) {
        int[][] matrix =
                new int[][] {
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
                };
        System.out.println(searchMatrix(matrix, 5));

        int[][] matrix0 =
                new int[][] {
                    {1, 3, 5, 7, 9},
                    {2, 4, 6, 8, 10},
                    {11, 13, 15, 17, 19},
                    {12, 14, 16, 18, 20},
                    {21, 22, 23, 24, 25}
                };
        System.out.println(searchMatrix(matrix0, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;

        for (int[] ints : matrix) {
            if (search(ints, target, 0, n - 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean search(int[] array, int target, int left, int right) {
        if (left > right) return false;
        if (left >= array.length) return false;

        if (array[left] == target || array[right] == target) return true;

        int mid = (left + right) / 2;
        if (array[mid] == target) return true;

        return (array[mid] > target)
                ? search(array, target, left, mid - 1)
                : search(array, target, mid + 1, right);
    }
}
