package medium.dualPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 三数之和，优化后的hash法
 *
 * <p>解答成功: 执行耗时:88 ms,击败了11.07% 的Java用户 内存消耗:45.4 MB,击败了70.35% 的Java用户
 *
 * @author by liangzj
 * @since 2022/10/9 21:08
 */
public class ThreeSumV2Main {
    public static void main(String[] args) {
        int[] a = new int[] {-1, 0, 1, 2, -1, -4};
        int[] b = new int[] {0, 0, 0, 0};
        //
        System.out.println(threeSum(a));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 第三个数是前两个数和的相反数
                Integer third = map.get(-(nums[first] + nums[second]));
                // 存在则说明和为0，剩下的就是判断
                if (third != null && third > second) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }

        return result;
    }
}
