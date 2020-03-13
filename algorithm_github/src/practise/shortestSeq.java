package practise;

import java.util.HashMap;
import java.util.Map;

/*
* 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。

返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class shortestSeq {
    public int[] shortestSeq(int[] big, int[] small) {
        int[] ans = new int[2];
        //标记是否更新了ans
        ans[1] = -1;
        //用来存储small的值和位置,方便查找
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i],i);
        }
        //当count==0时表示[left,right]包含small全部元素
        int count = small.length;
        //用来统计[left,right]中small[i]的个数
        int[] help = new int[small.length];
        int left = 0, right = 0;
        while (right<big.length){
            if (map.containsKey(big[right])){
                //如果big[right]在small中,则help的相应位置+1
                help[map.get(big[right])]++;
                //如果是第一次加1,则count--;
                if (help[map.get(big[right])] == 1)
                    count-- ;
            }
            //当count==0时,则尽量右移left以找到最短
            while (count == 0){
                //big[left]不在small中,直接右移
                if (!map.containsKey(big[left]))
                    left++;
                //big[left]在small中,但计数超过1,则减小计数,再右移
                else if (help[map.get(big[left])]>1){
                    help[map.get(big[left])]--;
                    left++;
                }
                //big[left]在small中,且计数为1,则将计数修改为0,此时count也要加1,然后视情况是否更新ans
                else{
                    help[map.get(big[left])]--;
                    count ++;
                    if (ans[1] == -1 || (right-left < ans[1] - ans[0])){
                        ans[0] = left;
                        ans[1] = right;
                    }
                    left++;
                }
            }
            right ++;
        }
        if (ans[1] == -1)
            return new int[0];
        return ans;
    }
}
