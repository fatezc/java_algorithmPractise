package practise;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
* 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CanReorderDoubled {
    public boolean canReorderDoubled(int[] A) {
        if (A==null||A.length==0)
            return true;
        int minus = 0,plus = 0,zeros = 0;
        for (int i : A) {
            if (i == 0)
                zeros++;
            else if (i<0)
                minus++;
            else if (i>0)
                plus++;
        }
        if (zeros%2 == 1||minus%2==1||plus%2==1)
            return false;
        TreeMap<Integer,Integer> minusmap = new TreeMap<>();
        TreeMap<Integer,Integer> plusmap = new TreeMap<>();
        for (int i : A) {
            if (i<0)
                minusmap.put(-i,minusmap.getOrDefault(-i,0)+1);
            if (i>0)
                plusmap.put(i,plusmap.getOrDefault(i,0)+1);
        }
        //每次都从最小的找，因为最小的不可能是某个数的两倍
        while (!minusmap.isEmpty()){
            Map.Entry<Integer, Integer> integerIntegerEntry = minusmap.pollFirstEntry();
            int key = integerIntegerEntry.getKey();
            int value = integerIntegerEntry.getValue();
            if (!minusmap.containsKey(key*2))
                return false;
            else if (minusmap.get(key*2)<value)
                return false;
            else if (minusmap.get(key*2) == value)
                minusmap.remove(key*2);
            else minusmap.put(key*2,minusmap.get(key*2)-value);
        }
        while (!plusmap.isEmpty()){
            Map.Entry<Integer, Integer> integerIntegerEntry = plusmap.pollFirstEntry();
            int key = integerIntegerEntry.getKey();
            int value = integerIntegerEntry.getValue();
            if (!plusmap.containsKey(key*2))
                return false;
            else if (plusmap.get(key*2)<value)
                return false;
            else if (plusmap.get(key*2) == value)
                plusmap.remove(key*2);
            else plusmap.put(key*2,plusmap.get(key*2)-value);
        }
        return true;
    }
}
