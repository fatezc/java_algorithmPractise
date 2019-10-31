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
        比较原则:比如是"12","121",则比较"121212"和"121121",即s1*s2.length和s2*s1.length
                或者比较s1+s2和s2+s1,但由于这样会多生成两个字符串,所以会多耗费时空
         */
        PriorityQueue<Integer> dui = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                int i = 0;
                while (i<s1.length()+s2.length()){
                    if (s1.charAt(i%s1.length())>s2.charAt(i%s2.length()))
                        return -1;
                    else if (s1.charAt(i%s1.length())<s2.charAt(i%s2.length()))
                        return 1;
                    ++i;
                }
                return 0;
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
