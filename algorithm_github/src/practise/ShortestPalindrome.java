package practise;

import java.util.Stack;

/*
* 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
* */
public class ShortestPalindrome {
    //即找到以s[0]开头的最长回文串
    public String shortestPalindrome(String s) {
        if (s == null||s.length()==0)
            return s;
        char ch = s.charAt(0);
        //用一个栈来存储s中等于s(0)的位置
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                stack.push(i);
        }
        int temp = 0;
        //从栈顶开始判断0到该位置是否是回文串
        while (!stack.isEmpty()){
             temp = stack.pop();
            boolean huiWen = isHuiWen(s, temp);
            if (huiWen)
                break;
        }
        char[] ans = new char[2*s.length()-temp-1];
        for (int i = ans.length-1,j = s.length()-1; i >=ans.length/2 ; i--,j--) {
            ans[i] = s.charAt(j);
        }
        for (int i = 0; i < ans.length / 2; i++) {
            ans[i] = ans[ans.length-1-i];
        }
        return String.valueOf(ans);
    }
    public boolean isHuiWen(String s,int end){
        for (int i = 0; i < end/2+1; i++) {
            if (s.charAt(i) != s.charAt(end-i))
                return false;
        }
        return true;
    }
}
