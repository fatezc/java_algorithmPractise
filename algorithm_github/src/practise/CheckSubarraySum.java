package practise;

import java.util.HashMap;
import java.util.HashSet;

/*
* 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/continuous-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CheckSubarraySum {
    //用一个set来保存以第i个元素为结尾的可能的sum，由于对其进行了%k运算，所以set.size<k，故时间复杂度为O（n*k）
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums==null||nums.length<2||k<0)
            return false;
        if (k == 0){
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0&&nums[i+1]==0)
                    return true;
            }
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i <nums.length ; i++) {
            Object[] objects = set.toArray();
            for (Object object : objects) {
                set.remove(object);
                int temp = ((int)object + nums[i])%k;
                if (temp == 0)
                    return true;
                set.add(temp);
            }
            set.add(nums[i]);
        }
        return false;
    }

    /*
    官方解答：在这种方法中，我们使用 HashMap 来保存到第 ii 个元素为止的累积和，但我们对这个前缀和除以 kk 取余数。原因如下：

我们遍历一遍给定的数组，记录到当前位置为止的 sum%ksum 。一旦我们找到新的 sum%ksum 的值（即在 HashMap 中没有这个值），我们就往 HashMap 中插入一条记录 (sum%k, i)(sum 。

现在，假设第 ii 个位置的 sum%ksum 的值为 remrem 。如果以 ii 为左端点的任何子数组的和是 kk 的倍数，比方说这个位置为 jj ，那么 HashMap 中第 jj 个元素保存的值为 (rem + n*k)\%k(rem+n∗k)%k ，其中 nn 是某个大于 0 的整数。我们会发现 (rem + n*k)\%k = rem(rem+n∗k)%k=rem ，也就是跟第 ii 个元素保存到 HashMap 中的值相同。

基于这一观察，我们得出结论：无论何时，只要 sum%ksum 的值已经被放入 HashMap 中了，代表着有两个索引 ii 和 jj ，它们之间元素的和是 kk 的整数倍。因此，只要 HashMap 中有相同的 sum\%ksum%k ，我们就可以直接返回 \teat{True} 。

作者：LeetCode
链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

}
