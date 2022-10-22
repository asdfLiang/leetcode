package medium.dualPointer;

import java.util.*;

/**
 * 三数之和
 *
 * <p>解答成功: 执行耗时:899 ms,击败了4.99% 的Java用户 内存消耗:46.3 MB,击败了5.06% 的Java用户
 *
 * @author by liangzj
 * @since 2022/10/9 21:08
 */
public class ThreeSumMain {
    public static void main(String[] args) {
        //
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap();
        HashSet<List<Integer>> distinctSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                // 第三个数是前两个数和的相反数
                Integer third = map.get(-(nums[first] + nums[second]));
                // 存在则说明和为0，剩下的就是判断
                if (third != null && third > second) {
                    List<Integer> temp = Arrays.asList(nums[first], nums[second], nums[third]);

                    // 如果这个组合还不存在，放到结果集中，否则跳过
                    if (!distinctSet.contains(temp)) {
                        result.add(temp);
                        distinctSet.add(temp);
                    }
                }
            }
        }

        return result;
    }
}
