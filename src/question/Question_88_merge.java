package question;

/**
 * @author liupeidong
 * Created on 2019/10/2 0:27
 */
public class Question_88_merge {

    /*给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

        说明:

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
        示例:

        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出: [1,2,2,3,5,6] */

    /*
    * 简单的滑动窗口
    * easy
    * */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int len1 = 0;
        int len2 = 0;
        int alen = 0;
        while (len1 < m && len2 < n) {
            if (nums1[len1] < nums2[len2]) {
                arr[alen++] = nums1[len1++];
            } else {
                arr[alen++] = nums2[len2++];
            }
        }
        if (len1 == m) {
            int size = n - len2;
            for (int i = 0; i < size; i++) {
                arr[alen++] = nums2[len2++];
            }
        }
        if (len2 == n) {
            int size = m - len1;
            for (int i = 0; i < size; i++) {
                arr[alen++] = nums1[len1++];
            }
        }
        if (m + n >= 0) System.arraycopy(arr, 0, nums1, 0, m + n);
    }
}
