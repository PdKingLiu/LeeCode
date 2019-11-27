package question;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/11/27 23:01
 */
public class Question_155_MinStack {

    class MinStack {

        /**
         * initialize your data structure here.
         */

        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            add(x);
        }

        private void add(int x) {
            if (list.size() == 0) {
                list.add(x);
                return;
            } else if (list.size() == 1) {
                if (list.get(0) > x) {
                    list.add(0, x);
                } else {
                    list.add(x);
                }
                return;
            }
            int left = 0;
            int right = list.size() - 1;
            int middle = 0;
            while (left <= right) {
                middle = (right + left) >>> 1;
                if (list.get(middle) == x) {
                    break;
                } else if (list.get(middle) > x) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            if (list.get(middle) == x) {
                list.add(middle, x);
            } else if (list.get(middle) < x) {
                if (list.size() - 1 == middle) {
                    list.add(x);
                } else {
                    list.add(middle + 1, x);
                }
            } else {
                list.add(middle, x);
            }
        }

        public void pop() {
            int tem = stack.pop();
            list.remove(new Integer(tem));
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return list.get(0);
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
