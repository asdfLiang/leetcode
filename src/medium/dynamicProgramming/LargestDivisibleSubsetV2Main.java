package medium.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by liangzj
 * @since 2022/10/19 21:24
 */
public class LargestDivisibleSubsetV2Main {
    public static void main(String[] args) {
        //

        int[] nums = new int[] {1, 2, 4, 8};
        int[] nums1 = new int[] {1, 2, 3};

        List<Integer> list1 = largestDivisibleSubset(nums);
        List<Integer> list2 = largestDivisibleSubset(nums1);

        System.out.println();
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] largestLen = new int[nums.length];

        Arrays.sort(nums);
        Arrays.fill(largestLen, 1);

        int maxLen = 1;
        int maxVal = nums[0];
        for (int self = 1; self < nums.length; self++) {
            for (int small = 0; small < self; small++) {
                if (nums[self] % nums[small] == 0) {
                    largestLen[self] = Math.max(largestLen[self], largestLen[small] + 1);
                }
            }

            if (largestLen[self] > maxLen) {
                maxLen = largestLen[self];
                maxVal = nums[self];
            }
        }

        if (maxLen == 1) {
            return Collections.singletonList(maxVal);
        }

        List<Integer> res = new ArrayList<>();
        for (int tail = nums.length - 1; tail >= 0; tail--) {
            if (maxVal % nums[tail] == 0 && largestLen[tail] == maxLen) {
                res.add(nums[tail]);
                maxLen--;
                maxVal = nums[tail];
            }
        }

        return res;
    }
}
