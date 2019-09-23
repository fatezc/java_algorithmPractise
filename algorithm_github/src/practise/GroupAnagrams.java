package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
* 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
* */
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null||strs.length==0)
            return null;
        HashMap<String,List> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] help = strs[i].toCharArray();
            Arrays.sort(help);
            String s = String.valueOf(help);
            if (!map.containsKey(s)){
                map.put(s,new ArrayList());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList(map.values());

    }
}
