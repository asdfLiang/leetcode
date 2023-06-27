package medium.lengthOfLIS;

/**
 * 300. 最长递增子序列（看过解析）
 *
 * @since 2023/6/27 1:03
 * @author by liangzj
 */
public class LengthOfLISMain {
    public static void main(String[] args) {
        LengthOfLISMain obj = new LengthOfLISMain();

        System.out.println(obj.lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int length = nums.length;
        int[] lis = new int[nums.length];
        lis[0] = 1;

        int maxLis = 1;
        for (int end = 1; end < length; end++) {
            int max = 1;
            for (int i = 0; i < end; i++) {
                if (nums[i] < nums[end]) max = Math.max(max, lis[i] + 1);
            }
            lis[end] = max;
            maxLis = Math.max(maxLis, max);
        }

        return maxLis;
    }
}
