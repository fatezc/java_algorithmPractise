package practise;

import java.util.HashMap;
import java.util.Map;

/*
* 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

返回森林中兔子的最少数量。
示例:
输入: answers = [1, 1, 2]
输出: 5
解释:
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

输入: answers = [10, 10, 10]
输出: 11

输入: answers = []
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rabbits-in-forest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumRabbits {
    //如果i,j兔子颜色相同,则answers[i]必然等于answers[j],故用一个map存储answers
    //注意类似于[1,1,1]情况,虽然三个都是1,但最少也要4只兔子
    //map的KEY就是answers[i],而value表示目前为止还没出现在answers中的同一种颜色的兔子数
    public int numRabbits(int[] answers) {
        if (answers.length==0)
            return 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : answers) {
            if (i == 0)
                ans++;
           else if (map.containsKey(i)){
                int value = map.get(i);
                if (value==1)
                    map.remove(i);
                else map.put(i,value-1);
            }else {
                map.put(i,i);
                ans+=i+1;
            }
        }
        return ans;
    }
}
