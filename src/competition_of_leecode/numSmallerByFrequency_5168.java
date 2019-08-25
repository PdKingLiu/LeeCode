package competition_of_leecode;

import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/8/25 11:04
 */
public class numSmallerByFrequency_5168 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        get(queries, q);
        get(words, w);
        Arrays.sort(w);
        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int j = w.length - 1; j >= 0; j--) {
                if (q[i] < w[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    private void get(String[] queries, int[] q) {
        char[] chars;
        for (int i = 0; i < queries.length; i++) {
            chars = queries[i].toCharArray();
            Arrays.sort(chars);
            char c = chars[0];
            int j = 1;
            for (j = 1; j < chars.length && chars[j] == c; j++) ;
            q[i] = j;
        }
    }
}
