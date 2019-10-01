package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,ans,new ArrayList<>());
        return ans;
    }
    //回溯法
    public void backtrack(int[] candidates , int target, int i , List<List<Integer>> ans, ArrayList<Integer> tmp_list){
        if (target == 0)
            {ans.add(new ArrayList<>(tmp_list));
                return;
            }
        if (target<0||i>=candidates.length)
            return;
        //包含该数
        tmp_list.add(candidates[i]);
        backtrack(candidates,target-candidates[i],i+1,ans,tmp_list);
        tmp_list.remove(tmp_list.size()-1);

        /*
        去重
        为啥能通过比较相同然后移动扫描下标就能去重？
        假设[l, r]区间中要找一个和为target。通过函数backtrack(l,r)就能求出来解。
        而如果[l+1, r]区间有好几个值跟v[l]相等，但是此区间==v[l]元素的个数一定比v[l, r]区间==v[l]元素的个数少；
        所以对于"含有v[l]的解"中，前者的答案一定包含后者，所以我们只需要求一次就行；
        后面相同的元素直接跳过去。
         */
        while (i+1<candidates.length&&candidates[i+1] == candidates[i])
            ++i;

        //不包含该数
        backtrack(candidates,target,i+1,ans,tmp_list);
    }

}
