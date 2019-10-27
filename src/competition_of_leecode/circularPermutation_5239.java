package competition_of_leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/10/27 12:41
 */
public class circularPermutation_5239 {

    /*5239. 循环码排列 显示英文描述

        用户通过次数300
        用户尝试次数406
        通过次数306
        提交次数627
        题目难度Medium

        给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：

        p[0] = start
        p[i] 和 p[i+1] 的二进制表示形式只有一位不同
        p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同

        示例 1：

        输入：n = 2, start = 3
        输出：[3,2,0,1]
        解释：这个排列的二进制表示是 (11,10,00,01)
             所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
        示例 2：

        输出：n = 3, start = 2
        输出：[2,6,7,5,4,0,1,3]
        解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)

        提示：

        1 <= n <= 16
        0 <= start < 2^n*/


    /*
    * 可以使用回溯
    * 也可以使用位运算
    * 题目类似格雷编码
    * */

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 1 << n; i++) {
            int tem = i ^ i >> 1;
            list.add(tem);
            if (tem == start) {
                index = i;
            }
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(index % list.size()));
            index++;
        }
        return list2;
    }
}
