package medium.searchMatrix;

/**
 * 74. 搜索二维矩阵
 *
 * @author liangzj
 * @since 2023/6/5 23:19
 */
public class SearchMatrixMain {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (search(nums, target)) {
                return true;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];

            if (num == target) {
                return true;
            }

            if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
