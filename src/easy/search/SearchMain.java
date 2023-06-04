package easy.search;
/**
 * 704. 二分查找
 *
 * @since 2023/6/4 22:25
 * @author by liangzj
 */
public class SearchMain {
    public static void main(String[] args) {}

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];

            if (num == target) {
                return mid;
            }

            if (target < num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
