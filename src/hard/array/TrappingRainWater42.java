package hard.array;

import java.util.Stack;

public class TrappingRainWater42 {


    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        new TrappingRainWater42().trap2(a);
    }
    public int trap(int[] h) {
        if (h.length <= 2) return 0;
        Stack<Integer> stack = new Stack<>();
        int head = 0;
        int tail = h.length - 1;
        while (head < h.length - 1 && h[head] < h[head + 1]) head++;
        while (tail > head && h[tail] < h[tail - 1]) tail--;
        stack.push(head);
        int cap = 0;
        for (int i = head; i <= tail; i++) {
//            如果当前不是递减的数组，就pop出来，计算pop之后，左边为peek，右边为i的容器，能存的水
            while (!stack.isEmpty() && h[i] > h[stack.peek()]) {
                int left = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                cap += (Math.min(h[i], h[stack.peek()]) - h[left]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return cap;
    }


    public int trap2(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
//        统计第i个元素，左边最大的值
        int[] leftMax = new int[n];
//        统计第i个元素，右边最大的值
        int[] rightMax = new int[n];
        int result = 0;

        // Initialize end points
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for(int i = 1; i < n - 1; i++) {
            result = result + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return result;
    }
}
