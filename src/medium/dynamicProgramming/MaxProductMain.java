package medium.dynamicProgramming;

/**
 * 乘积最大子数组
 *
 * @author by liangzj
 * @since 2022/10/18 22:20
 */
public class MaxProductMain {

    public static void main(String[] args) {
        //
        int[] arr1 = new int[] {2, 3, -2, 4};
        int[] arr2 = new int[] {-2, 0, -1};
        System.out.println(maxProductV1(arr1));
        System.out.println(maxProductV1(arr2));
    }

    /**
     * @param nums
     * @return
     */
    public static int maxProductV1(int[] nums) {
        int[] dp = new int[nums.length];

        int max = nums[0];
        int zeroNum = 0;
        int negtiveNum = 0;
        for (int start = 0; start < nums.length; start++) {
            dp[start] = nums[start];
            max = (dp[start] > max) ? dp[start] : max;
            if (start == 0 && nums[start] < 0) {
                negtiveNum = 1;
            }
            if (start == 0 && nums[start] == 0) {
                zeroNum++;
            }

            for (int end = start + 1; end < nums.length; end++) {
                dp[end] = dp[end - 1] * nums[end];
                max = (dp[end] > max) ? dp[end] : max;
                if (start == 0 && nums[end] < 0) {
                    negtiveNum++;
                }
                if (start == 0 && nums[end] == 0) {
                    zeroNum++;
                }
            }

            if (start == 0 && zeroNum == 0 && negtiveNum % 2 == 0) {
                return dp[nums.length - 1];
            }
        }

        return max;
    }

    /**
     * 内存超限制
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int start = 0; start < nums.length; start++) {
            dp[start][start] = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                dp[start][end] = dp[start][end - 1] * nums[end];
            }
        }

        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                max = (dp[i][j] > max) ? dp[i][j] : max;
            }
        }

        return max;
    }
}
