package question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * @author liupeidong
 * Created on 2019/8/5 10:15
 */
public class Question_77_combine {

    HashSet<Integer> set = new HashSet<>();

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 0, k);
        return lists;
    }

    private void backtrack(int n1, int n, int k) {
        if (n == k) {
            List<Integer> list = new ArrayList<>(set);
            lists.add(list);
            return;
        }
        for (int i = 1; i <= n1; i++) {
            if (set.contains(i)) {
                return;
            }
            set.add(i);
            backtrack(n1, n + 1, k);
            set.remove(i);
        }
    }
}
