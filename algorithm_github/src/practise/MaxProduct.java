package practise;
/*
* 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxProduct {
    /*
    因为全是小写字母，所以可以用一个32位整型来记录每个字符串出现了哪些字母
    如果两个字符串没有相同的字母，则没有同为1的位，则相与为0
     */
    public int maxProduct(String[] words) {
        int[] help = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                help[i] = help[i] | (1<<words[i].charAt(j)-'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((help[i]&help[j]) == 0)
                   ans = Math.max(ans,words[i].length()*words[j].length());
            }
        }
        return ans;
    }
}
