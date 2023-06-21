package medium.jump2;
/**
 * 45. 跳跃游戏 II （看过解析）
 *
 * @since 2023/6/21 21:02
 * @author by liangzj
 */
public class JumpIIMain {
    public static void main(String[] args) {
        JumpIIMain obj = new JumpIIMain();
        System.out.println(obj.jump(new int[] {2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int[] minSteps = new int[nums.length];
        minSteps[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int farthest = nums[i] + i;
            if (farthest >= nums.length - 1) {
                return minSteps[i];
            }

            for (int j = i + 1; j <= farthest; j++) {
                if (minSteps[j] == 0) minSteps[j] = minSteps[i] + 1;
                else minSteps[j] = Math.min(minSteps[j], minSteps[i] + 1);
            }
        }

        return minSteps[nums.length - 1];
    }
}
