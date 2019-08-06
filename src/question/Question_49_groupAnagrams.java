package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/6 15:04
 */
public class Question_49_groupAnagrams {

    /*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

        示例:

        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
        输出:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ] */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<Integer>> mapIndex = new HashMap<>();
        HashMap<HashMap<Character, Integer>, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String string = strs[i];
            HashMap<Character, Integer> map = getSet(string);
            hashMap.put(map, hashMap.getOrDefault(map, 0) + 1);
            List<Integer> list = mapIndex.get(map);
            if (list != null) {
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
                mapIndex.put(map, list);
            }
        }
        List<List<String>> listList = new ArrayList<>();
        for (HashMap<Character, Integer> map : mapIndex.keySet()) {
            List<Integer> list = mapIndex.get(map);
            List<String> stringList = new ArrayList<>();
            for (int a : list) {
                stringList.add(strs[a]);
            }
            listList.add(stringList);
        }
        return listList;
    }

    private HashMap<Character, Integer> getSet(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }
        return map;
    }

}
