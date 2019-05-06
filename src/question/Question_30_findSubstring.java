package question;

import java.util.*;

/**
 * @author liupeidong
 * Created on 2019/5/6 10:05
 */
public class Question_30_findSubstring {

    public static void main(String[] args) {
        System.out.println(findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashSet<String> set = new HashSet<>();
        perm(set, words, 0, words.length - 1);
        Iterator<String> iterator = set.iterator();
        ArrayList<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            String s1 = iterator.next();
            int index = s.indexOf(s1);
            while (index != -1) {
                list.add(index);
                index = s.indexOf(s1, index + 1);
            }
        }
        return list;
    }

    public static void perm(HashSet<String> set, String[] strings, int start, int end) {
        if (start == end) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <= end; i++) {
                stringBuilder.append(strings[i]);
            }
            set.add(stringBuilder.toString());
        } else {
            for (int i = start; i <= end; i++) {
                swap(strings, i, start);
                perm(set, strings, start + 1, end);
                swap(strings, i, start);
            }
        }
    }

    private static void swap(String[] strings, int start, int end) {
        String tem = strings[end];
        strings[end] = strings[start];
        strings[start] = tem;
    }

}
