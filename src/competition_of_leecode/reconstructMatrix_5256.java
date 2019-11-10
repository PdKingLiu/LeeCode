package competition_of_leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/11/10 13:38
 */
public class reconstructMatrix_5256 {

    /*5256. 重构 2 行二进制矩阵 显示英文描述

        用户通过次数691
        用户尝试次数812
        通过次数700
        提交次数2213
        题目难度Medium

        给你一个 2 行 n 列的二进制数组：

        矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
        第 0 行的元素之和为 upper。
        第 1 行的元素之和为 lower。
        第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
        你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。

        如果有多个不同的答案，那么任意一个都可以通过本题。

        如果不存在符合要求的答案，就请返回一个空的二维数组。

        示例 1：

        输入：upper = 2, lower = 1, colsum = [1,1,1]
        输出：[[1,1,0],[0,0,1]]
        解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
        示例 2：

        输入：upper = 2, lower = 3, colsum = [2,2,1,1]
        输出：[]
        示例 3：

        输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
        输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]

        提示：

        1 <= colsum.length <= 10^5
        0 <= upper, lower <= colsum.length
        0 <= colsum[i] <= 2*/

    /*
    * 这个题乍一看，给我的第一直觉就是回溯。
    * 结果。。。数据量 `1 <= colsum.length <= 10^5` 哈哈，稳稳的超时。
    * 回溯思路如下
    * 是1的话分为两种情况
    * 是0和2的话就是一种情况
    * 借用两个变量nowUpper 和 nowLower来记录当前的值
    * */

    /*
    * 最后想想，这个题其实并不是什么算法题，两遍循环就搞定了。
    * */

    /* 第一次把2的全部填完。这时切记要检查upper 和 lower
    * 第二次填的就是1的，如果upper 还可以填，就先填upper的，否则就填lower的。最后都不能填的话，那就意味着，还有1没放入，但是upper lower的值不允许放，这种情况下，直接就无解了
    * 最后转换成list即可
    * */

    private int nowUpper = 0;
    private int nowLower = 0;
    private boolean isFind = false;
    private List<Integer> temListUpper = new ArrayList<>();
    private List<Integer> temListLower = new ArrayList<>();

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(0, lists, upper, lower, colsum);
        return lists;
    }

    private void backtrack(int n, List<List<Integer>> lists, int upper, int lower, int[] colsum) {
        if (n == colsum.length) {
            if (upper == nowUpper && lower == nowLower) {
                lists.add(new ArrayList<>(temListUpper));
                lists.add(new ArrayList<>(temListLower));
                isFind = true;
            }
            return;
        }
        if (isFind || (nowLower > lower && nowUpper > upper)) {
            return;
        }
        switch (colsum[n]) {
            case 0:
                temListLower.add(0);
                temListUpper.add(0);
                backtrack(n + 1, lists, upper, lower, colsum);
                temListLower.remove(temListLower.size() - 1);
                temListUpper.remove(temListUpper.size() - 1);
                break;
            case 1:
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        temListLower.add(0);
                        temListUpper.add(1);
                        nowUpper += 1;
                        backtrack(n + 1, lists, upper, lower, colsum);
                        temListLower.remove(temListLower.size() - 1);
                        temListUpper.remove(temListUpper.size() - 1);
                        nowUpper -= 1;
                    } else {
                        temListLower.add(1);
                        temListUpper.add(0);
                        nowLower += 1;
                        backtrack(n + 1, lists, upper, lower, colsum);
                        temListLower.remove(temListLower.size() - 1);
                        temListUpper.remove(temListUpper.size() - 1);
                        nowLower -= 1;
                    }
                }
                break;
            case 2:
                nowUpper += 1;
                nowLower += 1;
                temListLower.add(1);
                temListUpper.add(1);
                backtrack(n + 1, lists, upper, lower, colsum);
                temListLower.remove(temListLower.size() - 1);
                temListUpper.remove(temListUpper.size() - 1);
                nowUpper -= 1;
                nowLower -= 1;
                break;
        }
    }

    public List<List<Integer>> reconstructMatrix2(int upper, int lower, int[] colsum) {
        List<List<Integer>> lists = new ArrayList<>(3);
        int[][] arr = new int[2][colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                arr[0][i] = 1;
                arr[1][i] = 1;
                upper--;
                lower--;
                if (upper < 0 || lower < 0) {
                    return lists;
                }
            }
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    arr[0][i] = 1;
                    upper--;
                } else if (lower > 0) {
                    arr[1][i] = 1;
                    lower--;
                } else {
                    return lists;
                }
            }
        }
        if (lower != 0 || upper != 0) {
            return lists;
        }
        List<Integer> list1 = new ArrayList<>(colsum.length + 1);
        List<Integer> list2 = new ArrayList<>(colsum.length + 1);
        for (int i = 0; i < arr[0].length; i++) {
            list1.add(arr[0][i]);
            list2.add(arr[1][i]);
        }
        lists.add(list1);
        lists.add(list2);
        return lists;
    }


}
