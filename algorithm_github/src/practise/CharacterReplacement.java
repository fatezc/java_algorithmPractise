package practise;
/*
* 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意:
字符串长度 和 k 不会超过 104。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CharacterReplacement {
    /*
    ahp数组表示[left~right]范围内26个字母的个数

     */
    public int characterReplacement(String s, int k) {
        if (s == null||s.length() == 0)
            return 0;
        char[] charArray = s.toCharArray();
        int[] ahp = new int[26];
        int left = 0,right=0,ans = 0;
        ahp[charArray[right] - 'A']++;
        int maxCount = 1;
        while (right<charArray.length-1){
            while (right<charArray.length-1 && right-left+1<= k+maxCount){
                right++;
                ahp[charArray[right]-'A']++;
                maxCount = findmax(ahp);
                if(right-left+1<= k+maxCount)
                    ans = Math.max(right-left+1,ans);
            }
            ahp[charArray[left]-'A']--;
            maxCount = findmax(ahp);
            left++;
        }
        return ans;
    }
    public int findmax(int[] arr){
        int maxCount = 0;
        for (int i : arr) {
            maxCount = Math.max(maxCount,i);
        }
        return maxCount;
    }
}
