package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/2 9:35
 */
public class Question_39_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            list.add(candidates[i]);
            backtrack(target - candidates[i], i, candidates, list, lists);
            list.remove((Integer) candidates[i]);
        }
    }

}
