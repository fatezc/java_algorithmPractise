package practise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

* */
public class LetterCombinations {
    private List<String> ans;
    private HashMap<Character,String> map;
    public List<String> letterCombinations(String digits) {
        ans = new LinkedList<>();
        if (digits == null||digits.length()== 0)
            return ans;
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        help(digits,new StringBuilder());
        return ans;
    }
    //简单的回溯
    public void help(String digits,StringBuilder s){
        if (digits == null)
            ans.add(s.toString());
        else {
            char c = digits.charAt(0);
            String s1 = map.get(c);
            for (int i = 0; i < s1.length(); i++) {
                s.append(s1.charAt(i));
                if (digits.length() == 1)
                    help(null,s);
                else help(digits.substring(1),s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}
