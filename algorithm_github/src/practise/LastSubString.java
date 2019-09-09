package practise;
/*
给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
输入："abab"
输出："bab"
解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/last-substring-in-lexicographical-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
设立left和right两个指针,每次用right找比left大的,
如果s[right]<s[left]则right++
如果 s[right]>s[left]则left = right++
如果s[right]==s[left]则再挨个比较left和right后面的,直到s[left+count]!=s[right+count]或者right+count==len:
                当以left开头的字符串小时:left=right++;
                反之:right =right+count+1;(这是因为此时s[right,right+count]必小于s[left])


 */
public class LastSubString {
    public String lastSubstring(String s) {
       int left = 0,right = 1,len = s.length();
       while (right<len){
           if ((int)s.charAt(right)<(int)(s.charAt(left)))
               right++;
           else if ((int)s.charAt(right)>(int)(s.charAt(left))){
               left = right++;
           }else {
               int count = 1;
               while (right+count<len&&(int)s.charAt(right+count)==(int)(s.charAt(left+count)))
                   count++;
               if (right+count == len||(int)s.charAt(right+count)<(int)(s.charAt(left+count))){
                   right += count+1;
               } else left = right++;
           }
       }
       return s.substring(left);
    }
}
