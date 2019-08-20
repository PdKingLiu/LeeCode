package question;

import java.util.*;

/**
 * @author liupeidong
 * Created on 2019/8/20 16:19
 */
public class Question_90_subsetsWithDup {

    /*给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

        说明：解集不能包含重复的子集。

        示例:

        输入: [1,2,2]
        输出:
        [
          [2],
          [1],
          [1,2,2],
          [2,2],
          [1,2],
          []
        ] */

    HashSet<List<Integer>> set = new HashSet<>();
    LinkedList<Integer> tem = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums.length, nums);
        return new ArrayList<>(set);
    }

    private void backtrack(int i, int length, int[] nums) {
        if (i == length) {
            set.add(new ArrayList<>(tem));
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
