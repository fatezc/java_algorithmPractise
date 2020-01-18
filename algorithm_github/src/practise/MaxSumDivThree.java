package practise;

import java.util.PriorityQueue;
import java.util.stream.Stream;

/*
* 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
* */
public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        int ans = 0;
        //用来存储数组里对三取余得1的最小的两个值
        PriorityQueue<Integer> one = new PriorityQueue<>(2,(x,y)-> x-y);
        //用来存储数组里对三取余得2的最小的两个值
        PriorityQueue<Integer> two = new PriorityQueue<>(2,(x,y)-> x-y);
        //先得到数组的sum,并且找到one和two
        for (int num : nums) {
            ans += num;
            if (num % 3==1){
               one.add(num);
            }
            if (num%3==2){
                two.add(num);
            }
        }
        /*
        如果sum%3==1,那么就找Math.min(one.peek(),two.poll()+two.poll(),要考虑其中可能某些数不存在的情况
         */
        if (ans%3 ==1){
            if (one.size()>=1 && two.size()>=2)
                return ans - Math.min(one.peek(),two.poll()+two.poll());
            if (one.size()<1 && two.size()>=2)
                return ans - two.poll()-two.poll();
            if (one.size() >= 1)
                return ans - one.poll();
            return 0;
        }
        /*
        sum%3==2同理
         */
        if (ans%3 ==2){
            if (one.size()>=2 && two.size()>=1)
                return ans - Math.min(two.peek(),one.poll()+one.poll());
            if (two.size()<1 && one.size()>=2)
                return ans - one.poll()-one.poll();
            if (two.size() >= 1)
                return ans - two.poll();
            return 0;
        }
        //sum%3==0的情况
        return ans;
    }
}
