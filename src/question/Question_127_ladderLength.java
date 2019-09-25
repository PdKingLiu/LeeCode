package question;

import java.util.*;

/**
 * @author liupeidong
 * Created on 2019/9/3 16:47
 */
public class Question_127_ladderLength {

    /*给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

        每次转换只能改变一个字母。
        转换过程中的中间单词必须是字典中的单词。
        说明:

        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
        示例 1:

        输入:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        输出: 5

        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
             返回它的长度 5。
        示例 2:

        输入:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        输出: 0

        解释: endWord "cog" 不在字典中，所以无法进行转换。 */

    /*
    * 1.寻找每个单词的孩子（相差一个字符）
    * 2.广度优先遍历
    * */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        HashMap<String, List<String>> hashMap = new HashMap<>(wordList.size());
        HashMap<String, Boolean> isUsedMap = new HashMap<>(wordList.size());
        getChild(hashMap, isUsedMap, wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int sum = 1;
        boolean isFind = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                List<String> list = hashMap.get(s);
                for (String s1 : list) {
                    if (s1.equals(endWord)) {
                        isFind = true;
                        break;
                    }
                    if (!isUsedMap.get(s1)) {
                        queue.add(s1);
                        isUsedMap.put(s1, true);
                    }
                }
            }
            sum++;
            if (isFind) {
                break;
            }
        }
        if (isFind) {
            return sum;
        } else {
            return 0;
        }
    }

    private void getChild(HashMap<String, List<String>> hashMap, HashMap<String, Boolean> hashMap2, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            List<String> list = hashMap.get(wordList.get(i));
            hashMap2.put(wordList.get(i), false);
            if (list == null) {
                list = new ArrayList<>(wordList.size());
                hashMap.put(wordList.get(i), list);
            }
            for (int j = 0; j < wordList.size(); j++) {
                if (j != i) {
                    int count = 0;
                    for (int k = 0; k < wordList.get(0).length(); k++) {
                        if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                            count++;
                            if (count == 2) {
                                break;
                            }
                        }
                    }
                    if (count == 1) {
                        list.add(wordList.get(j));
                    }
                }
            }
        }
    }

}
