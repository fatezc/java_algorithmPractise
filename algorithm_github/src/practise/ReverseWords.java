package practise;
/*
* 给定一个字符串，逐个翻转字符串中的每个单词。
* 输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ReverseWords {
    //先将每个单词逆转，再将整个字符串逆转
    public String reverseWords(String s) {
        if (s==null||s.length()==0)
            return s;
        char[] str = s.toCharArray();
        int left = 0,right = 0;
        while (left<str.length&&right<str.length){
            while (left<str.length&&str[left] == ' ') left++;
            right = left;
            while (right<str.length-1&&str[right+1]!=' ') right++;
            if (left<right&&right<str.length)
            reverseChar(str,left,right);
            left = right+1;
        }
        reverseChar(str,0,str.length-1);
        StringBuilder ans = new StringBuilder("");
        left = 0;
        while (left<str.length&&str[left] == ' ') left++;
        while (left<str.length){
            if (str[left] != ' ')
                ans.append(str[left++]);
            else {
                while (left<str.length&&str[left] == ' ') left++;
                if (left<str.length)
                    ans.append(' ');
            }
        }
        return ans.toString();
    }
    public void reverseChar(char[] str,int left,int right){
        char temp;
        for (int i = left,j=right; i <j ; i++,j--) {
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

}
