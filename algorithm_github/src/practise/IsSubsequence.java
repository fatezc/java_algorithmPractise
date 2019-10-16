package practise;

import java.util.*;

/*
* 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
后续挑战 :

如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0)
            return true;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            List<Integer> list;
            if (!map.containsKey(t.charAt(i))){
                list = new LinkedList<>();
            }else {
                 list = map.get(t.charAt(i));
            }
            list.add(i);
            map.put(t.charAt(i),list);
        }
        for (int i = 0,pre = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                return false;
            List<Integer> list = map.get(s.charAt(i));
            int len = list.size();
            for (int j = 0; j < len; j++) {
                if (list.get(0)<pre)
                    list.remove(0);
                else break;
            }
            if (list.isEmpty())
                return false;
            pre = list.get(0);
            list.remove(0);
        }
        return true;
    }

}
