package practise;

import java.util.Arrays;
import java.util.HashMap;

/*
* 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。

arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

我们最多能将数组分成多少块？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxChunksToSorted {
    /*
    将arr和其排序好的数组help对比，如果存在某段[i,j]使得arr[i,j]内与help[i,j]内具有相同的元素（各元素的位置可以不相同，如{2,1}和{1,2}）,就将[left,right]划为一个块
     */
    public int maxChunksToSorted(int[] arr) {
        int[] help = Arrays.copyOf(arr,arr.length);
        Arrays.sort(help);
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) == -1)
                map.remove(arr[i]);
            else map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if (map.containsKey(help[i]) && map.get(help[i]) == 1)
                map.remove(help[i]);
            else map.put(help[i],map.getOrDefault(help[i],0)-1);
            if (map.size() == 0)
                ans++;
        }
        return ans;
    }
}
