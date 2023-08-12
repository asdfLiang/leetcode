package hot100.easyMoveZeroes;
/**
 * 283. 移动零
 *
 * @since 2023/8/12 8:53
 * @author by liangzj
 */
public class MoveZeroes {
    public static void main(String[] args) {}

    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        int arrayLen = nums.length;
        int tailIdx = arrayLen;

        for (int i = 0; i < arrayLen; i++) {
            if (nums[i] == 0) {
                ++zeroNum;
                --tailIdx;
            } else if (zeroNum != 0) {
                nums[i - zeroNum] = nums[i];
            }
        }

        for (int i = tailIdx; i < arrayLen; i++) nums[i] = 0;
    }
}
