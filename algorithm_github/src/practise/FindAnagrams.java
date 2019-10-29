package practise;

import java.util.*;

/*
* 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同的字符串。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        if (s == null||s.length()<p.length())
            return ans;
        Map<Character,Integer> map = new HashMap<>();
        int len = p.length();
        for (int i = 0; i < len; i++) {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
        }
        Object[] values = map.values().toArray();
        Boolean flag = true;
        for (Object value : values) {
            if ((int)value!=0){
                flag = false;
                break;
            }
        }
        if (flag)
            ans.add(0);
        for (int i = 1; i < s.length() - len+1; i++) {
            if (map.containsKey(s.charAt(i-1)))
                map.put(s.charAt(i-1),map.get(s.charAt(i-1))+1);
            if (map.containsKey(s.charAt(i-1+len)))
                map.put(s.charAt(i-1+len),map.get(s.charAt(i-1+len))-1);
            flag = true;
            values = map.values().toArray();
            for (Object value : values) {
                if ((int)value!=0){
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans.add(i);
        }
        return ans;
    }
}
