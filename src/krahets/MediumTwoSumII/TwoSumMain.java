package krahets.MediumTwoSumII;

/**
 * 167. 两数之和 II - 输入有序数组(双指针)
 *
 * @since 2024/3/22 20:34
 * @author by liangzj
 */
public class TwoSumMain {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] {-1, -1};
    }
}
