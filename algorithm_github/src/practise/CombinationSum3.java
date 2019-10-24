package practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
* 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CombinationSum3 {
    private LinkedList<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans= new LinkedList<>();
        int[] arr = new int[9];
        Arrays.fill(arr,1);
        help(k,n,arr,new LinkedList<>());
        return ans;
    }
    public void help(int k,int n ,int[] arr,LinkedList<Integer> list){
        if (k<0||n<0)
            return;
        if (k == 0 && n==0){
            ans.add(new LinkedList<>(list));
        }
        else {
            /*
            下列i的初始化确保list内的元素按从小到大排列，以避免[1,2]和[2,1]算两种情况
             */
            for (int i = list.size() == 0?0:list.peekLast(); i < arr.length; i++) {
                if (arr[i]==1){
                    arr[i] = 0;
                    list.add(i+1);
                    help(k-1,n-i-1,arr,list);
                    list.removeLast();
                    arr[i] = 1;
                }
            }
        }
    }


}
