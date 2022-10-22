package medium.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by liangzj
 * @since 2022/10/19 21:24
 */
public class LargestDivisibleSubsetMain {
    public static void main(String[] args) {
        //

        int[] nums = new int[] {1, 2, 4, 8};
        int[] nums1 = new int[] {1, 2, 3};

        List<Integer> list1 = largestDivisibleSubset(nums);
        List<Integer> list2 = largestDivisibleSubset(nums1);

        System.out.println();
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] next = new int[nums.length];
        int[] largest = new int[nums.length];

        Arrays.sort(nums);

        int maxIdx = 0;
        for (int first = 0; first < nums.length - 1; first++) {
            next[first] = 0;
            for (int second = first + 1; second < nums.length; second++) {
                //
                if (nums[second] % nums[first] == 0) {
                    next[first] = second;
                    largest[second] = largest[first] + 1;
                    maxIdx = second;
                    break;
                }
            }
        }

        return Collections.emptyList();
    }
}
