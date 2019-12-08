package practise;
/*
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
* */
public class CountSubstrings {
    public int countSubstrings(String s) {
        //假设s = "aa",则先初始化str为“#a#a#”
        char[] str = new char[s.length()*2+1];
        str[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            str[i*2+1] = s.charAt(i);
            str[i*2+2] = '#';
        }
        int ans = 0;
        for (int i = 1; i <str.length-1 ; i++) {
            int len = 0;
            while (i-(len+1)>=0 && i+(len+1)<str.length &&str[i-(len+1)] == str[i+(len+1)]) len++;
            ans += (len+1)/2;
        }
        return ans;
    }
}
