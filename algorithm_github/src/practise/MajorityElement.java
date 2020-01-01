package practise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
*
* 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。*/
public class MajorityElement {
    /*
    算法思想：用one和two来存储两个不同的数，count_1和count_2分别存储这两个数的个数
    遍历nums，当nums[i]是其中的一个时，相应的次数加1，否则count_1和count_2都减一（也就是三个数抵消）
    当遍历完之后，如果count_1>0，则表示one可能是个数超过3分之1个的数，count_2同理，
    再遍历一遍以确定
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        if (nums.length<3){
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            for (Integer integer : set) {
                ans.add(integer);
            }
            return ans;
        }
        int one = 0,two = 0,count_1 = 0,count_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == one && count_1>0){
                ++count_1;
                continue;
            }
            if (nums[i] == two && count_2>0){
                ++count_2;
                continue;
            }
            if (count_1 == 0){
                one = nums[i];
                count_1 = 1;
                continue;
            }
            if (count_2 == 0){
                two = nums[i];
                count_2 = 1;
                continue;
            }
            count_1--;
            count_2--;
        }
        count_1 = count_1 == 0?-nums.length:0;//如果count_1为0则不可能超过1/3，所以直接赋值为-n，这样下面的ans就不会添加one了
        count_2 = count_2 == 0?-nums.length:0;//同上
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == one)
                count_1++;
            if (nums[i] == two)
                count_2++;
        }
        if (count_1>nums.length/3)
            ans.add(one);
        if (count_2>nums.length/3)
            ans.add(two);
        return ans;
    }
}
