package question;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/4/7 13:15
 */
public class Question_4_FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a[] = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            a[i] = nums1[i];
        }
        for (int i = nums1.length; i < nums1.length + nums2.length; i++) {
            a[i] = nums2[i - nums1.length];
        }
        Arrays.sort(a);
        if (a.length % 2 == 0) {
            return (float) (a[a.length / 2] + a[a.length / 2 - 1]) / 2;
        } else {
            return a[a.length / 2];
        }
    }

}
