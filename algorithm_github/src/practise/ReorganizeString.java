package practise;

import java.util.Arrays;
import java.util.Comparator;

/*
* 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。
* 注意:

S 只包含小写字母并且长度在[1, 500]区间内。
* */
public class ReorganizeString {
    public String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        int[][] help = new int[26][2];
        /*
        先统计个字母的数量，help[i][0]表明是哪个字母，help[i][1]统计数量
         */
        for (int i = 0; i < help.length; i++) {
            help[i][0] = i;
        }
        for (int i = 0; i < S.length(); i++) {
            help[S.charAt(i)-'a'][1]++;
        }
        //然后按照数量排序
        Arrays.sort(help, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        //如果数量最大的字母超过S长度的一半则返回空
        if (help[0][1]>(S.length()+1)/2)
            return "";
        char[] ans = new char[S.length()];
        int cur = 0;
        //i和j表示该到help[i][j]
        int i = 0,j = 0;
        //第一遍从0开始每隔一个位置插入一个字母
        while (cur<ans.length){
            if (j == help[i][1]){
                ++i;
                j = 0;
                continue;
            }
            ans[cur] = (char)(help[i][0]+'a');
            cur += 2;
            ++j;
        }
        //第二遍从1开始每隔一个位置插入一个字母
        cur = 1;
        while (cur<ans.length){
            if (j == help[i][1]){
                ++i;
                j = 0;
                continue;
            }
            ans[cur] = (char)(help[i][0]+'a');
            cur += 2;
            ++j;
        }
        return new String(ans);
    }
}
