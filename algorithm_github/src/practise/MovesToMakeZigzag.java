package practise;
/*
* 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。

如果符合下列情况之一，则数组 A 就是 锯齿数组：

每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
返回将数组 nums 转换为锯齿数组所需的最小操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int even = 0,odd = 0,max;
        for (int i = 0; i < nums.length; i++) {
            max = -1;//确保不做更改时even+=max+1这一行不改变even的值，odd += max+1不改变odd的值
            /*
            下面分两种情况，分别统计偶数大和奇数大的时候要操作数，最后返回二者最小值
             */
            if (i%2==0){
                if (i-1>=0 && nums[i-1]<=nums[i]) max = Math.max(max,nums[i]-nums[i-1]);
                if (i+1<nums.length && nums[i+1]<=nums[i]) max = Math.max(max,nums[i]-nums[i+1]);
                even += max+1;
            }
            if (i%2==1){
                if (i-1>=0 && nums[i-1]<=nums[i]) max = Math.max(max,nums[i]-nums[i-1]);
                if (i+1<nums.length && nums[i+1]<=nums[i]) max = Math.max(max,nums[i]-nums[i+1]);
                odd += max+1;
            }
        }
        return Math.min(even,odd);
    }
}
