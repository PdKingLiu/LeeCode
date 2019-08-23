package competition_of_leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/4 11:08
 */
class SnapshotArray_5149 {

    int[] arr;
    HashMap<Integer, HashMap<Integer, Integer>> map;
    int snap_id = 0;

    public SnapshotArray_5149(int length) {
        arr = new int[length];
        map = new HashMap<>();
    }

    private static void fun(String string, int i, int[] anInt, SnapshotArray_5149 snapshotArray) {
        System.out.print("i:" + i + "-");
        switch (string) {
            case "set":
                System.out.print(snapshotArray.set(anInt[0], anInt[1]) + " ");
                break;
            case "get":
                System.out.print(snapshotArray.get(anInt[0], anInt[1]) + " ");
                break;
            case "snap":
                System.out.print(snapshotArray.snap() + " ");
                break;
        }
    }

    public String set(int index, int val) {
        arr[index] = val;
        HashMap<Integer, Integer> map1 = map.get(index);
        if (map1 == null) {
            map1 = new HashMap<>();
            map1.put(snap_id, val);
        } else {
            map1.put(snap_id, val);
        }
        map.put(index, map1);
        return null;
    }

    public int snap() {
        snap_id++;
        return snap_id - 1;
    }

    public int get(int index, int snap_id) {
        HashMap<Integer, Integer> map1 = map.get(index);
        if (map1 == null) {
            return 0;
        } else {
            List<Integer> list = new ArrayList<>(map1.keySet());
            Collections.sort(list);
            if (list.get(list.size() - 1) < snap_id) {
                return map1.get(list.get(list.size() - 1));
            } else if (list.get(0) > snap_id) {
                return 0;
            } else if (map1.get(snap_id) != null) {
                return map1.get(snap_id);
            } else if (map1.get(snap_id) == null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < snap_id && list.get(i + 1) > snap_id) {
                        return map1.get(list.get(i));
                    }
                }
            }
            return 0;
        }
    }
}