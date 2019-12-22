package practise;

import java.util.*;

/*
*
* 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集
* 输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
* */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<List<Integer>> help = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //先统计每个数字的个数
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //加入空集
        ans.add(new LinkedList<>());
        Set<Integer> set = map.keySet();
        /*
        如果map里有<1,2>,<2,2>,则以下操作为先在ans里加入了[1],[1,1],然后加入了[2],[1,2][1,1,2][2,2][1,2,2][1,1,2,2]，
        即每次取一对键值对，针对ans里已有的子集，全部依次加入0~value个key
         */
        for (Integer key : set) {
            help.clear();
            List<List<Integer>> temp = ans;
            ans = help;
            help = temp;
            for (int i = 0; i <= map.get(key); i++) {
                for (List<Integer> list : help) {
                    LinkedList<Integer> list1 = new LinkedList<>(list);
                    for (int j = 0; j < i; j++) {
                        list1.add(key);
                    }
                    ans.add(list1);
                }
            }
        }
        return ans;
    }
}
