package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        //应对num中全为0的特殊情况
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum == 0)
            return "0";

        /*
        算法思想:给数组中元素排序,为了方便取num[i]中的某位,先将其转为string
       然后比较s1+s2和s2+s1
         */
        PriorityQueue<Integer> dui = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                int i = 0;
                return (s1+s2).compareTo(s2+s1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            dui.add(nums[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!dui.isEmpty()){
            stringBuilder.append(dui.poll());
        }
        return stringBuilder.toString();
    }
}
