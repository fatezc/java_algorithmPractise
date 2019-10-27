package practise;
/*
*给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。

确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
提示：

-1000 ≤ nums[i] ≤ 1000
nums[i] ≠ 0
0 ≤ nums.length ≤ 5000
* 进阶：

你能写出时间时间复杂度为 O(n) 和额外空间复杂度为 O(1) 的算法吗？
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/circular-array-loop
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null||nums.length <2)
            return false;
        int begin ,help,len = nums.length,cur,count_plus = 1001,count_minus = -1001 ;

        //先排除循环长度等于1的数字，设为0即排除
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i])%nums.length == 0)
                nums[i] =0;
        }

        for (begin = 0;begin<len;begin++){
            /*
            正向时，一边查找一边给路径上的值修改为count_plus，如果最后能回到这条路径，这返回true，
            如果不能则代表该点不可能成环，值修改为count_plus相当于打了标记，下次遍历到该点时由于count_plus大于原数组的值得范围，所以不进入判断
             */
            if (nums[begin]>0&&nums[begin]<=1000){
                help = (begin+nums[begin])%len;
                nums[begin] = count_plus;
                while (nums[help]>0&&nums[help]<=1000){
                    cur = (help+nums[help])%len;
                    nums[help] = count_plus;
                    help = cur;
                }
                if (nums[help] == count_plus)
                    return true;
                count_plus++;
            }
            /*
            负向时同理
             */
            if (nums[begin]<0&&nums[begin]>=-1000){
                help = begin+nums[begin];
                if (help<0){
                    help = help%len+len;
                }
                nums[begin] = count_minus;
                while (nums[help]<0&&nums[help]>=-1000){
                    cur = help+nums[help];
                    if (cur<0)
                        cur = cur%len+len;
                    nums[help] = count_minus;
                    help =cur;
                }
                if (nums[help] == count_minus)
                    return true;
                count_minus--;
            }
        }
        return false;
    }
}
