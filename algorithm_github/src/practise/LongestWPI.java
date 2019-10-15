package practise;

import java.util.Stack;

/*
* 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。

我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。

所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。

请你返回「表现良好时间段」的最大长度。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-well-performing-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LongestWPI {
    /*
    将hours按是否为劳累的一天改写，是为1，不是为-1
    然后求出前缀和数组sum，其中sum[0] = 0表示无前缀时，sum[i]对应hours[0~i-1]的和
    则题意即可转换为求max(j-i),其中i,j满足：i<j,且sum[j]>sum[i]
    即可转换为“962.最大宽度坡”问题，见MaxWidthRamp类算法注释
     */
    public int longestWPI(int[] hours) {
        if (hours==null||hours.length==0)
            return 0;
        int ans = 0;
        int[] sum = new int[hours.length+1];
        sum[0] = 0;
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i]>8?1:-1;
            sum[i+1] = sum[i]+hours[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <sum.length ; i++) {
            if (sum[i]<sum[stack.peek()])
                stack.push(i);
        }
        for (int i = sum.length-1; i >= 0; i--) {
            int temp = i;
            while (!stack.isEmpty() && sum[i]>sum[stack.peek()]) temp = stack.pop();
            ans = Math.max(ans,i-temp);
        }
        return ans;
    }

}
