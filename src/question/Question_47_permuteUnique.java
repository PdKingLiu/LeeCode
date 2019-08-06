package question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/6 11:58
 */
public class Question_47_permuteUnique {

    /*给定一个可包含重复数字的序列，返回所有不重复的全排列。

    示例:

        输入: [1,1,2]
        输出:
        [
          [1,1,2],
          [1,2,1],
          [2,1,1]
        ] */

    HashSet<List<Integer>> set = new HashSet<>();
    List<Integer> innr = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isVisited = new boolean[nums.length];
        backtrack(nums, 0, nums.length);
        return new ArrayList<>(set);
    }

    private void backtrack(int[] nums, int i, int length) {
        if (i == length) {
            set.add(new ArrayList<>(innr));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!isVisited[j]) {
                innr.add(nums[j]);
                isVisited[j] = true;
                backtrack(nums, i + 1, length);
                innr.remove(innr.size() - 1);
                isVisited[j] = false;
            }
        }
    }
}
