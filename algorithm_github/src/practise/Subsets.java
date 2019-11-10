package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Subsets {
    private  List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        for (int i = 0; i <= nums.length; i++) {
            backtrak(nums,i,new LinkedList<>(),0);
        }
        return ans;
    }
    public void backtrak(int[] nums , int len,List<Integer> list,int cur){
        if (list.size() == len){
            ans.add(new LinkedList<>(list));
            return;
        }
        if (cur == nums.length)
            return;
        for (int i = cur; i < nums.length ; i++) {
            list.add(nums[i]);
            backtrak(nums,len,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
