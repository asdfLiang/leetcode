package hot150;


/**
 * 88. 合并两个有序数组
 * 
 * @since 2024/12/9 10:38
 * @author by liangzj9624
 */
public class EasyMerge {
    public static void main(String[] args){
        EasyMerge obj = new EasyMerge();

        obj.merge(new int[] {0}, 0, new int[] {1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;

        while (m - 1 >= 0 || n - 1 >= 0) {
            if (m - 1 >= 0 && n - 1 >= 0) {
                nums1[--total] = (nums1[m - 1] >= nums2[n - 1]) ? nums1[--m] : nums2[--n];
            } else if (m <= 0) {
                nums1[--total] = nums2[--n];
            } else {
                return;
            }
        }
    }
}
