package competition_of_leecode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author liupeidong
 * Created on 2019/8/25 13:51
 */
public class DinnerPlates_5165 {

    public static void main(String[] args) {
        String[] strings = {"DinnerPlates", "push", "push", "push", "push", "push", "popAtStack", "push", "push", "popAtStack", "popAtStack", "pop", "pop", "pop", "pop", "pop"};
        int[][] a = {{2}, {1}, {2}, {3}, {4}, {5}, {0}, {20}, {21}, {0}, {2}, {}, {}, {}, {}, {}};
        fun(strings, a);
    }

    private static void fun(String[] strings, int[][] a) {
        DinnerPlates_5165 obj = null;
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "push":
                    obj.push(a[i][0]);
                    System.out.print("null,");
                    break;
                case "popAtStack":
                    System.out.print(obj.popAtStack(a[i][0]) + ",");
                    break;
                case "pop":
                    System.out.print(obj.pop() + ",");
                    break;
                case "DinnerPlates":
                    obj = new DinnerPlates_5165(a[i][0]);
                    System.out.print("null,");
                    break;
            }
        }
    }

    HashMap<Integer, Deque<Integer>> map = new HashMap<>(100000);
    int capacity;
    int lastIndex = -1;
    TreeSet<Integer> treeSet = new TreeSet();


    public DinnerPlates_5165(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        Deque<Integer> stack;
        if (treeSet.size() != 0) {
            stack = map.get(treeSet.first());
            stack.push(val);
            if (stack.size() == capacity) {
                treeSet.remove(treeSet.first());
            }
        } else {
            stack = map.get(lastIndex);
            if (stack == null) {
                lastIndex++;
                stack = new LinkedList<>();
                stack.push(val);
                map.put(lastIndex, stack);
            } else {
                if (stack.size() < capacity) {
                    stack.push(val);
                } else {
                    lastIndex++;
                    stack = new LinkedList<>();
                    stack.push(val);
                    map.put(lastIndex, stack);
                }
            }
        }
    }

    public int pop() {
        Deque<Integer> stack;
        for (int i = lastIndex; i >= 0; i--) {
            stack = map.get(i);
            if (stack.size() != 0) {
                return stack.pop();
            } else {
                lastIndex--;
            }
        }
        return -1;
    }

    public int popAtStack(int index) {
        treeSet.add(index);
        Deque<Integer> stack = map.get(index);
        if (stack == null) {
            return -1;
        } else {
            if (stack.size() == 0) {
                return -1;
            } else {
                return stack.pop();
            }
        }
    }
}
