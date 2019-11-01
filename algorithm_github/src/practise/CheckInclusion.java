package practise;

import java.util.HashMap;
import java.util.Map;

/*
*给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 

示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        //将s1的所有字母存入map
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        /*
        下面开始从头遍历s2的每个长度=s1.length的字串，每次移动右边的元素对应的map值减1，左边的元素加一，如果某个元素对应的value等于0则删除
        如果某个字串对应的map为空则代表该字串包含的字母与s1包含的字母一样返回true
         */
        for (int i = 0; i < s1.length(); i++) {
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)-1);
            if (map.get(s2.charAt(i))==0)
                map.remove(s2.charAt(i));
        }
        if (map.isEmpty())
            return true;
        for (int left = 0,right =s1.length();right<s2.length();right++,left++){
            map.put(s2.charAt(right),map.getOrDefault(s2.charAt(right),0)-1);
            map.put(s2.charAt(left),map.getOrDefault(s2.charAt(left),0)+1);
            if (map.get(s2.charAt(right))==0)
                map.remove(s2.charAt(right));
            //可能s2[right] == s2[left]，而在上一行被remove了，所以这里要先判断是否存在
            if (map.containsKey(s2.charAt(left))&&map.get(s2.charAt(left)) == 0)
                map.remove(s2.charAt(left));
            if (map.isEmpty())
                return true;
        }
        return false;
    }
}
