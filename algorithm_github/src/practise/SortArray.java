package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一个整数数组 nums，将该数组升序排列。
* 提示：

1 <= A.length <= 10000
-50000 <= A[i] <= 50000
* */
/*
由于限定了A[i]的范围，所以可以采用桶排序
 */
public class SortArray {
    public List<Integer> sortArray(int[] nums) {
        int[] help = new int[100001];
        for (int num : nums) {
            help[num+50000]++;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < help.length; i++) {
            while (help[i]>0){
                ans.add(i-50000);
                help[i]--;
            }
        }
        return ans;
    }
}
