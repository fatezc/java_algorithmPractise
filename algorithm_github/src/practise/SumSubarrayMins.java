package practise;

import java.util.Stack;

/*
* 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。

由于答案可能很大，因此返回答案模 10^9 + 7。
* */
public class SumSubarrayMins {
    //应用单调栈找出每个数字左右两边离他最近的比他小的位置，如果是[left,cur,right],则以该数字为最小值得子数组含有（cur-left）*(right-cur)个
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0,mod = (int)Math.pow(10,9)+7;
        Integer pop=0;
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i]<= A[stack.peek()]){
                pop = stack.pop();
                ans = (ans + (i-pop)*(pop-(stack.isEmpty()?-1:stack.peek()))*A[pop])%mod;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            pop = stack.pop();
            ans  = (ans + (A.length- pop)*(pop-(stack.isEmpty()?-1:stack.peek()))*A[pop])%mod;
        }
        return ans;
    }
}
