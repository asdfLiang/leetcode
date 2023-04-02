package medium.recurrence;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author by liangzj
 * @since 2022/10/23 17:20
 */
public class CombinationSumMain {

    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    /**
     * 深度有限遍历
     *
     * @param candidates 备选数组
     * @param target 目标值
     * @param ans 结果集
     * @param combine 当前组合
     * @param idx 待选数字下标
     */
    public static void dfs(
            int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        // 下标值超过待选数组长度
        if (idx == candidates.length) {
            return;
        }

        // 目标值剩余0，说明正好符合，加入结果集
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);

        // 选择当前数
        if (target - candidates[idx] >= 0) {
            // 加入当前组合中
            combine.add(candidates[idx]);
            // 继续向后加
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
