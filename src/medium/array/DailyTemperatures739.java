package medium.array;

import java.util.Stack;

public class DailyTemperatures739 {



//    堆栈思想
    public int[] dailyTemperatures(int[] T) {
        if(T.length == 1) return new int[]{0};

        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[T.length];
        stack.add(0);
        for (int i=1;i< T.length;i++){
            while (!stack.isEmpty()){
                if (T[stack.peek()] < T[i] ){
                    int index = stack.pop();
                    result[index] = i-index;
                } else {
                    break;
                }
            }
            stack.add(i);
        }
        return result;
    }
}
