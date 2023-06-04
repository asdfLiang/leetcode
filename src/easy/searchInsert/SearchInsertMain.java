package easy.searchInsert;
/**
 * 35. 搜索插入位置
 *
 * @since 2023/6/4 23:26
 * @author by liangzj
 */
public class SearchInsertMain {
    public static void main(String[] args) {
        SearchInsertMain obj = new SearchInsertMain();
        System.out.println(obj.searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(obj.searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(obj.searchInsert(new int[] {1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];

            if (num == target) {
                return mid;
            }

            if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (left + right + 1) / 2;
    }
}
