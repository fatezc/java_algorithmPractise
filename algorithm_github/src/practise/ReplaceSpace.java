package practise;
/*
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                ans.append("%20");
            else ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
