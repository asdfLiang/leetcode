package hot100.hardFindMedianSortedArrays;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @since 2024/6/13 下午11:01
 * @author by liangzj
 */
public class FindMedianSortedArraysMain {

    public static void main(String[] args) {
        FindMedianSortedArraysMain obj = new FindMedianSortedArraysMain();

        System.out.println(obj.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(obj.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(obj.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}));
        System.out.println(obj.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 7}));
        System.out.println(obj.findMedianSortedArrays(new int[] {3, 4}, new int[] {}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int mid = len / 2 + 1;

        if (len == 0) {
            return 0.0;
        } else if (len == 1) {
            return (nums1.length > 0) ? nums1[0] : nums2[0];
        }

        int p1 = 0, p2 = 0;
        int[] half = new int[mid];
        for (int i = 0; i < mid; i++) {
            if (p1 >= nums1.length) {
                half[i] = nums2[p2++];
            } else if (p2 >= nums2.length) {
                half[i] = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                half[i] = nums1[p1++];
            } else {
                half[i] = nums2[p2++];
            }
        }

        return (len % 2 != 0)
                ? half[half.length - 1]
                : ((double) half[half.length - 1] + (double) half[half.length - 2]) / 2;
    }
}
