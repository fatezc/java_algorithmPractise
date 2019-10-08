package practise;

import java.util.LinkedList;
import java.util.List;

/*
* 给定一个没有重复数字的序列，返回其所有可能的全排列。
* */
public class Permute {
    private List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList<>();
        if (nums==null||nums.length==0)
            return null;
        pailie(nums,0);
        return ans;
    }
    public void pailie(int[] nums,int len){
        if (len == nums.length){
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
            for (int j = len; j <nums.length ; j++) {
                int temp = nums[len];
                nums[len] = nums[j];
                nums[j] = temp;
                pailie(nums,len+1);
                temp = nums[len];
                nums[len] = nums[j];
                nums[j] = temp;
            }

    }

}
