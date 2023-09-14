package hot100;

/**
 * 560. 和为 K 的子数组
 *
 * @since 2023/9/14 20:42
 * @author by liangzj
 */
public class mediumSubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {-1, -1, 1}, 1));
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 1) return nums[0] == k ? 1 : 0;

        int total = 0, len = nums.length, sum;
        for (int i = 0; i < len; i++) {
            sum = nums[i];
            if (sum == k) total++;
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum == k) total++;
            }
        }

        return total;
    }
}
