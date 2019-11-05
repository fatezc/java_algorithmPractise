package practise;

import java.util.Map;

/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
* */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length()<=1)
            return s;
        int max_len = 1,position = 0;
        //以s[i]为中心向两边扩散求最长回文子串
        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            while (i-j>=0 && i+j<s.length() &&s.charAt(i-j) == s.charAt(i+j)) ++j;
            if (max_len< 2*j-1){
                max_len = 2*j-1;
                position = i-j+1;
            }
        }
        //以s[i]和s[i+1]为中心向两边扩散求最长回文子串
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 0;
            while (i-j>=0 && i+j+1<s.length() &&s.charAt(i-j) == s.charAt(i+j+1)) ++j;
            if (max_len<2*j+2){
                max_len = 2*j+2;
                position = i-j+1;
            }
        }
        return s.substring(position,position+max_len);
    }
}
