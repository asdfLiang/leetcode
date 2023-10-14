package hot100.mediumProductExceptSelf;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * @since 2023/10/14 22:44
 * @author by liangzj
 */
public class ProductExceptSelfMain {
    public static void main(String[] args) {
        ProductExceptSelfMain solution = new ProductExceptSelfMain();

        System.out.println(
                Arrays.toString(solution.productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int r = len - 2; r >= 0; r--) {
            right[r] = right[r + 1] * nums[r + 1];
        }

        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
