package competition_of_leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/9/15 10:31
 */
public class maxNumberOfBalloons_5189 {

    public static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>(1000);
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'b':
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    break;
                case 'a':
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    break;
                case 'l':
                    map.put(c, map.getOrDefault(c, 0) + 1);

                    break;
                case 'o':
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    break;
                case 'n':
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    break;
            }
        }
        map.put('l', map.getOrDefault('l', 0) / 2);
        map.put('o', map.getOrDefault('o', 0) / 2);
        List<Integer> list = new ArrayList<>(1000);
        for (Character c : map.keySet()) {
            list.add(map.get(c));
        }
        Collections.sort(list);
        if (list.size() == 0) {
            return 0;
        } else {
            return list.get(0);
        }
    }
}
