package practise;

import java.util.HashMap;

public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i]-difference,0)+1);
        }
        Object[] objects = map.values().toArray();
        int ans = 0;
        for (Object value : objects) {
            ans = Math.max(ans,(Integer) value);
        }
        return ans;
    }
}
