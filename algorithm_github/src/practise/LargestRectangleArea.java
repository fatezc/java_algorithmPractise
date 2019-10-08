package practise;

import java.util.Stack;

/*
* 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
* */
public class LargestRectangleArea {
    //运用单调栈对于每个柱子,找到他左右比他小的柱子的位置
    public int largestRectangleArea(int[] heights) {
        if(heights == null||heights.length == 0)
            return 0;
        int ans = heights[0];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty())
                stack.push(i);
            else if (heights[stack.peek()]<=heights[i])
                stack.push(i);
            else {
                while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                    int temp = stack.pop();
                    while (!stack.isEmpty()&&heights[stack.peek()] == heights[temp]) temp=stack.pop();
                    if (stack.isEmpty())
                        temp = heights[temp]*i;
                    else temp = heights[temp]*(i-stack.peek()-1);
                    ans = Math.max(ans,temp);
                }
                stack.push(i);
            }
        }
        //栈内还存在元素
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if(stack.isEmpty())
                //整个数组最小值的情况
                ans = Math.max(ans,heights[cur]*heights.length);
            else ans = Math.max(ans,heights[cur]*(heights.length-stack.peek()-1));
        }
        return ans;
    }
}
