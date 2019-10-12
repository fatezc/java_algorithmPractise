package practise;

import java.util.Stack;

/*
* 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。

找出 A 中的坡的最大宽度，如果不存在，返回 0 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-width-ramp
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        //先找到以A[0]开头的递减序列存入栈中
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()||A[stack.peek()]>A[i])
                stack.push(i);
        }
        /*然后从后往前遍历
        * 对于每个元素i，对于栈中的相邻元素a和b,数组A中介于a和b之间的元素必然大于A[a],
        * 如果A[i]比其中某个元素大则必然也大于A[a]，但坡的宽度肯定是比a到i小
        * */
        for (int i = A.length-1; i >=0 ; i--) {
            int temp = i;
            while (!stack.isEmpty()&&A[i]>=A[stack.peek()])
                temp = stack.pop();
            ans = Math.max(ans,i-temp);
        }
        return ans;

    }
}
