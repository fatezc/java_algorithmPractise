package practise;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
* */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0)
            return 0;
        if (s.length()==1)
            return 1;
        Map<Character,Integer> map = new HashMap<>();
        int ans = 1,left = 0,right = 0;
       while (right<s.length()){
           if (!map.containsKey(s.charAt(right))){
               map.put(s.charAt(right),right);
               ++right;
               ans = Math.max(ans,right-left);
           }else {
               int cur =map.get(s.charAt(right))+1;
               if (cur>left){
                   for (;left<cur;left++){
                       if (map.containsKey(s.charAt(left)))
                           map.remove(s.charAt(left));
                   }
               }

               map.put(s.charAt(right),right);
               right++;
           }
       }
        return Math.max(ans,right-left);
    }

}
