package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/2 10:17
 */
public class Question_40_combinationSum2 {

    /*给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

        candidates 中的每个数字在每个组合中只能使用一次。

        说明：

        所有数字（包括目标数）都是正整数。
        解集不能包含重复的组合。 
        示例 1:

        输入: candidates = [10,1,2,7,6,1,5], target = 8,
        所求解集为:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ] */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(target, 0, candidates, new ArrayList<>(), lists);
        return lists;
    }

    public void backtrack(int target, int start, int[] candidates, List<Integer> list, List<List<Integer>> lists) {
        if (target == 0) {
            List<Integer> list1 = new ArrayList<>(list);
            lists.add(list1);
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(target - candidates[i], i + 1, candidates, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
