package practise;

import java.util.*;

/*
* 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。

每一步，你可以从下标 i 跳到下标：

i + 1 满足：i + 1 < arr.length
i - 1 满足：i - 1 >= 0
j 满足：arr[i] == arr[j] 且 i != j
请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。

注意：任何时候你都不能跳到数组外面。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinJumps {
    /*
    广度优先搜索
    用一个map存储arr中值相同的下标
    用一个help更新第ans步所能到达的下标
    由于ans只增不减,故当到达arr时即为最少操作数
     */
    public int minJumps(int[] arr) {
        int ans = 0;
        if (arr == null || arr.length<=1)
            return ans;
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int[] help = new int[arr.length];
        Arrays.fill(help,Integer.MAX_VALUE);
        help[0] = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> integers = map.containsKey(arr[i])?map.get(arr[i]):new LinkedList<>();
            integers.add(i);
            map.put(arr[i],integers);
        }
        list.add(0);
        while (true){
            //第ans步时能到达的下标在此时的list中,由于后续会更改list的大小,所以此时记录
            int size = list.size();
            //步数+1
            ans++;
            //对于上一步能到达的下标进行循环,bfs找下一步能到达的所有下标
            for (int i = 0; i < size; i++) {
                Integer first = list.pollFirst();
                //当到达数组尾部时
                if (first  == help.length-1)
                    return help[first];
                //如果map还包含arr[first]
                if (map.containsKey(arr[first])){
                    LinkedList<Integer> list1 = map.get(arr[first]);
                    //删除map中的arr[first],避免不必要的操作,如果不这样最后一个样例会超时
                    map.remove(arr[first]);
                    //此时list1中就是与first同值得所有下标,一一判断
                    for (Integer integer : list1) {
                        if ( help[integer]>ans){
                            help[integer] = ans;
                            list.add(integer);
                        }
                    }
                }
                //first的前和后分别判断
                if (first-1>=0 && help[first-1]> ans){
                    help[first-1]=ans;
                    list.add(first-1);
                }
                if (first+1<help.length && help[first+1]>ans){
                    help[first+1] = ans;
                    list.add(first+1);
                }
            }
        }
    }
}
