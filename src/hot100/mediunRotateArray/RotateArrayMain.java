package hot100.mediunRotateArray;

import java.util.Arrays;

/**
 * 189. 轮转数组
 *
 * @since 2023/9/19 20:10
 * @author by liangzj
 */
public class RotateArrayMain {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        System.out.println(Arrays.toString(array));

        int[] array2 = {-1, -100, 3, 99};
        rotate(array2, 2);
        System.out.println(Arrays.toString(array2));
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length < 2) return;

        int len = nums.length;
        k = k % len;
        int[] tails = new int[k];
        // 记录要轮转到头部的数组
        for (int i = len - k; i < len; i++) tails[i - len + k] = nums[i];

        // 头部数组后移
        for (int i = len - k - 1; i >= 0; i--) nums[i + k] = nums[i];

        // 轮转的数组拼接到头部
        System.arraycopy(tails, 0, nums, 0, k);
    }
}
