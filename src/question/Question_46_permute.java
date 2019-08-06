package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/6 11:39
 */
public class Question_46_permute {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> innr = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        backtrack(nums, 0, nums.length);
        return lists;
    }

    private void backtrack(int[] nums, int i, int length) {
        if (i == length) {
            lists.add(new ArrayList<>(innr));
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
