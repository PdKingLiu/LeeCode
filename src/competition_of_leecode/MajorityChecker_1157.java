package competition_of_leecode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author liupeidong
 * Created on 2019/8/12 10:16
 */
public class MajorityChecker_1157 {

    int[] arr;
    int[] hash = new int[20002];
    HashSet<Integer> set = new HashSet<>();

    public MajorityChecker_1157(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        Arrays.fill(hash, 0);
        set.clear();
        for (int i = left; i <= right; i++) {
            hash[arr[i]] += 1;
            set.add(arr[i]);
        }
        for (Integer inte : set) {
            if (hash[inte] >= threshold) {
                return inte;
            }
        }
        return -1;
    }
}
