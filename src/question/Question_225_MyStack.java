package question;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liupeidong
 * Created on 2019/8/23 20:22
 */
public class Question_225_MyStack {

    Queue<Integer> queue1, queue2, tem;

    /**
     * Initialize your data structure here.
     */
    public Question_225_MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        tem = queue2;
        queue2 = queue1;
        queue1 = tem;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
