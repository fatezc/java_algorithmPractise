package practise;

import java.util.Arrays;
import java.util.HashMap;

/*
* 爱丽丝有一手（hand）由整数数组给定的牌。 

现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。

如果她可以完成分组就返回 true，否则返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hand-of-straights
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Object[] keyarr =  map.keySet().toArray();
        Arrays.sort(keyarr);
        //从小到大每次取W个，不满足则返回false
        for (Object o : keyarr) {
            if (map.get(o) == 0)
                map.remove(o);
            else {
                for (int i = 1; i < W; i++) {
                    if (!map.containsKey((int)o+i)||map.get((int)o +i)<map.get(o))
                        return false;
                    map.put((int)o+i,map.get((int)o+i)-map.get(o));
                }
                map.remove(o);
            }
        }
        if (map.isEmpty())
            return true;
        return false;
    }
}
