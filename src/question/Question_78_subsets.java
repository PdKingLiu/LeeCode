package question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/16 14:18
 */
public class Question_78_subsets {

    /*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

        说明：解集不能包含重复的子集。

        示例:

        输入: nums = [1,2,3]
        输出:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ] */

    List<List<Integer>> lists = new LinkedList<>();
    LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums.length, nums);
        return lists;
    }

    private void backtrack(int i, int length, int[] nums) {
        if (i == length) {
            lists.add(new ArrayList<>(tem));
            return;
        }
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                backtrack(i + 1, length, nums);
            } else {
                tem.add(nums[i]);
                backtrack(i + 1, length, nums);
                tem.remove(tem.size() - 1);
            }
        }
    }
}
