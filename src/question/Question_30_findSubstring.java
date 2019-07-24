package question;

import java.util.*;

import static java.util.Objects.isNull;

/**
 * @author liupeidong
 * Created on 2019/5/6 10:05
 */
public class Question_30_findSubstring {

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> indexList = new ArrayList<>();
        if (isNull(s) || s.length() == 0 || isNull(words) || words.length == 0) {
            return indexList;
        }
        int wordLen = words[0].length();
        int wordsSum = words.length;
        int length = wordLen * wordsSum;
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : words) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length() - length + 1; i++) {
            String tem = s.substring(i, i + length);
            System.out.println(tem);
            for (int j = 0; j < length; j += wordLen) {
                String s1 = tem.substring(j, j + wordLen);
                map1.put(s1, map1.getOrDefault(s1, 0) + 1);
            }
            if (map.equals(map1)) {
                indexList.add(i);
            }
            map1.clear();
        }
        return indexList;
    }


}
