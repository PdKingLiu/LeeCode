package common;

/**
 * @author liupeidong
 * Created on 2019/4/22 11:02
 */
public class MyStack {
    public int intVal;
    public char charVal;
    public String stringVal;
    public boolean booleanVal;
    public float floatVal;
    public double doubleVal;
    public MyStack next = null;

    public MyStack() {
    }

    public MyStack(double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public MyStack(float floatVal) {
        this.floatVal = floatVal;
    }

    public MyStack(boolean booleanVal) {
        this.booleanVal = booleanVal;
    }

    public MyStack(String stringVal) {
        this.stringVal = stringVal;
    }

    public MyStack(char charVal) {
        this.charVal = charVal;
    }

    public MyStack(int intVal) {
        this.intVal = intVal;
    }

    public static void push(MyStack myStack, MyStack node) {
        if (myStack == null || node == null) {
            return;
        }
        while (myStack.next != null) {
            myStack = myStack.next;
        }
        node.next = null;
        myStack.next = node;
    }

    public static boolean isEmpty(MyStack myStack) {
        if (myStack == null) {
            return true;
        }
        return myStack.next == null;
    }

    public static void pop(MyStack myStack) {
        if (isEmpty(myStack)) {
            return;
        }
        while (myStack.next.next != null) {
            myStack = myStack.next;
        }
        myStack.next = null;
    }

    public static MyStack getTop(MyStack myStack) {
        if (isEmpty(myStack)) {
            return null;
        }
        while (myStack.next != null) {
            myStack = myStack.next;
        }
        return myStack;
    }

    public static void show(MyStack myStack) {
        if (myStack == null) {
            System.out.println("MyStack:[null]");
            return;
        }
        if (isEmpty(myStack)) {
            System.out.println("MyStack:[]");
            return;
        }
        myStack = myStack.next;
        System.out.print("MyStack:[");
        while (myStack.next != null) {
            System.out.print(myStack.charVal + ",");
            myStack = myStack.next;
        }
        System.out.println(myStack.charVal + "]");
    }
}
