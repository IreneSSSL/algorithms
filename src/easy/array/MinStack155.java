package easy.array;

import java.util.Stack;

public class MinStack155 {

//    self-implementation of stack's function
//    key point is allocating an extra space to store min value of each node
    Stack<Integer> min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack155() {
        min= new Stack<Integer>();
        stack= new Stack<Integer>();
    }

    public void push(int x) {
        int m = x;
        if(!stack.isEmpty()){
            m = Math.min(min.peek(), x);
        }
        min.push(m);
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        min.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
