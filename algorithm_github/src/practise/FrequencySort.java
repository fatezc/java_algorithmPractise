package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/*
* 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
* */
public class FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        if (s==null||s.length()==0)
            return s;
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }
        int[][] help = new int[map1.keySet().size()][2];
        int i = 0;
        for (Character character : map1.keySet()) {
            help[i][0] = map1.get(character);
            help[i][1] = character;
            ++i;
        }
        Arrays.sort(help, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < help.length; j++) {
            for (int k = 0; k < help[j][0]; k++) {
                ans.append((char)help[j][1]);
            }
        }
        return ans.toString();
    }
}
