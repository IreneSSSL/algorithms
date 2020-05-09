package hard.array;

public class MaximumHistogram84 {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

//        rightLess[i]: the first right side bar that is smaller than heigths[i], so does leftless
        int[] rightLess = new int[heights.length];
        int[] leftLess = new int[heights.length];
        leftLess[0] = -1;
        rightLess[heights.length-1] = heights.length;

        int len = heights.length;
//        !!!!!!Amazing part
//        if heights[i-1] is smaller than heigths[i], then i-1 is what we want
//        but if heights[i-1] is bigger than heights[i], it means all the numbers between leftLess[heights[i-1]] and i-1 is larger or equal to heights[i-1],
//        which are also larger than heights[i]. we don't need to compare them with heights[i] again.
//        we could find a smaller one from leftLess[i-1] to 0;
        for (int i= 1;i<len;i++){
            int left = i-1;
            while (left>=0 && heights[left] >= heights[i]){
                left = leftLess[left];
            }
            leftLess[i] = left;
        }

        for (int i= len-2;i>=0;i--){
            int right = i+1;
            while (right<len && heights[right] >= heights[i]){
                right = rightLess[right];
            }
            rightLess[i] = right;
        }
//  ****************************************************************
        int max = 0;
        for (int i=0;i< heights.length;i++){
            max=Math.max(max, (rightLess[i]-leftLess[i]-1)*heights[i]);
        }
        return max;

    }


}
