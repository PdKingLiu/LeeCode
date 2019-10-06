package competition_of_leecode;

import java.util.HashMap;

/**
 * @author liupeidong
 * Created on 2019/10/6 13:49
 */
public class longestSubsequence_5214 {


    /*5214. 最长定差子序列 显示英文描述

        用户通过次数310
        用户尝试次数642
        通过次数317
        提交次数1712
        题目难度Medium

        给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。

        示例 1：

        输入：arr = [1,2,3,4], difference = 1
        输出：4
        解释：最长的等差子序列是 [1,2,3,4]。
        示例 2：

        输入：arr = [1,3,5,7], difference = 1
        输出：1
        解释：最长的等差子序列是任意单个元素。
        示例 3：

        输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
        输出：4
        解释：最长的等差子序列是 [7,5,3,1]。


        提示：

        1 <= arr.length <= 10^5
        -10^4 <= arr[i], difference <= 10^4*/

    /*
    * 通过Map存储每个值最长的序列
    * 在map中查找上一个值arr[i] - difference
    * 如果找到 这个下标的值就是  1 + integer
    * 否则就是1
    * */

    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int value : arr) {
            Integer integer = map.get(value - difference);
            if (integer == null) {
                map.put(value, 1);
            } else {
                map.put(value, 1 + integer);
            }
            max = Math.max(max, map.get(value));
        }
        return max;
    }


    /*
    * 暴力
    * n方 超时
    * */

    public int longestSubsequence2(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int front = arr[i];
            int tem = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - front == difference) {
                    tem++;
                    front = arr[j];
                }
            }
            max = Math.max(tem, max);
        }
        return max;
    }

}
