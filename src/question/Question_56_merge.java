package question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author liupeidong
 * Created on 2019/8/7 22:42
 */
public class Question_56_merge {

    /*给出一个区间的集合，请合并所有重叠的区间。

        示例 1:

        输入: [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        示例 2:

        输入: [[1,4],[4,5]]
        输出: [[1,5]]
        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 */

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        HashMap<Integer, Integer> tem = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int index = i;
            tem.put(intervals[i][0], intervals[i][1]);
            int value = intervals[i][1];
            while (index < intervals.length) {
                if (index + 1 < intervals.length) {
                    if (intervals[index][1] >= intervals[index + 1][0] || intervals[index + 1][0] <= value) {
                        if (intervals[index + 1][1] > value) {
                            value = intervals[index + 1][1];
                            tem.put(intervals[i][0], intervals[index + 1][1]);
                        }
                        index++;
                    } else {
                        i = index;
                        break;
                    }
                } else {
                    if (intervals[index][1] > value) {
                        tem.put(intervals[i][0], intervals[index][1]);
                    }
                    i = index;
                    break;
                }
            }
        }
        int[][] endArr = new int[tem.size()][2];
        int index = 0;
        for (Integer i : tem.keySet()) {
            endArr[index][0] = i;
            endArr[index][1] = tem.get(i);
            index++;
        }
        return endArr;
    }
}
