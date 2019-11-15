package practise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
* 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
* */
public class PartitionLabels {
    private List<Integer> ans;
    private Map<Character,Integer> map;
    public List<Integer> partitionLabels(String S) {
        ans = new LinkedList<>();
        map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i),i);
        }
        int cur = 0;
        while (cur<S.length()){
            cur = help(S,cur);
        }
        return ans;
    }
    //help函数作用为找到从S(cur)开始的最短片段长度，并返回该片段的下一个下标
    public int help(String S,int cur){
        int right = map.get(S.charAt(cur));
        if (right == cur){
            ans.add(right-cur+1);
            return right+1;
        }
        int preright = cur ;
        int left;
        do {
            left = preright;
            preright = right;
            for (int i = left+1; i < preright; i++) {
                if (map.get(S.charAt(i))>right)
                    right = map.get(S.charAt(i));
            }
        }while (preright != right);
        ans.add(right-cur+1);
        return right+1;
    }
}
