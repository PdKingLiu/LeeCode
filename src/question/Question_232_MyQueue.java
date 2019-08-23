package question;

import java.util.Stack;

/**
 * @author liupeidong
 * Created on 2019/8/23 20:00
 */
public class Question_232_MyQueue {

    Stack<Integer> stackIn, stackOut;

    /**
     * Initialize your data structure here.
     */
    public Question_232_MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackOut.isEmpty()) {
            if (stackIn.isEmpty()) {
                return -1;
            } else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
                return stackOut.pop();
            }
        } else {
            return stackOut.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackOut.isEmpty()) {
            if (stackIn.isEmpty()) {
                return -1;
            } else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
                return stackOut.peek();
            }
        } else {
            return stackOut.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
