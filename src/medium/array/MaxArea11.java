package medium.array;

public class MaxArea11 {


//    GOOD ONE, sliding window
//    Start with the maximum width container and go to a shorter width container
//    if there is a vertical line longer than the current containers shorter line.
//    This way we are compromising on the width but we are looking forward to a longer length container.
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int start = 0;
        int end = height.length -1;
        int maxArea = Math.min(height[start],height[end]) *(end - start) ;

        while (start < end){
            int area =  Math.min(height[start],height[end]) *(end - start) ;
            maxArea = Math.max(area, maxArea);
            if (height[start]<height[end]){
                start++;
            } else {
                end --;
            }
        }
        return maxArea;

    }
}
