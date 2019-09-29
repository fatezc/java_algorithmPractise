package practise;

import java.util.HashMap;
import java.util.Set;

/*
* 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
* */

/*
基于这些想法，可以使用了一个哈希表 map，它用于存储所有可能的索引的累积总和以及相同累加和发生的次数。我们以以下形式存储数据：(sum,sum 的出现次数)。
我们遍历数组nums并继续寻找累积总和。每当我们遇到一个新的和时，我们在hashmap中创建一个与该总和相对应的新条目。
如果再次出现相同的和，我们增加与mapmap中的和相对应的计数。
此外，对于遇到的每个总和，我们还确定已经发生 sum-ksum−k 总和的次数，因为它将确定具有总和 kk 的子阵列发生到当前索引的次数。
我们将 ans增加相同的量。

作者：LeetCode
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int ans = 0,sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
