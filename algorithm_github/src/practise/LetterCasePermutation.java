package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
* */
public class LetterCasePermutation {
    private List<String> ans;
    public List<String> letterCasePermutation(String S) {
        ans = new LinkedList<>();
        backtrak(S,0);
        return ans;
    }
    public void backtrak(String str,int cur){
        if (cur==str.length())
            ans.add(str);
        else {
            if (str.charAt(cur) >= 'a' && str.charAt(cur) <= 'z') {
                char[] chars = str.toCharArray();
                chars[cur] += 'A' - 'a';
                String string = String.valueOf(chars);
                backtrak(string, cur + 1);
            }
            if (str.charAt(cur) >= 'A' && str.charAt(cur) <= 'Z') {
                char[] chars = str.toCharArray();
                chars[cur] += 'a' - 'A';
                String string = String.valueOf(chars);
                backtrak(string, cur + 1);
            }
            backtrak(str, cur + 1);
        }
    }
}
