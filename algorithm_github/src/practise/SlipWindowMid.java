package practise;

import java.util.Arrays;

public class SlipWindowMid {
    /*
    * 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。
    * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-median
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public void  swap(int[] help,int i,int j){
        int temp = help[i];
        help[i] = help[j];
        help[j] = temp;
        return;
    }
    /*
    * help数组存储nums[i-k~i]的递增排列,到下一步时,用nums[i+1]替换help中等于nums[i-k]的值并调整help
    * 时间复杂度(n*k)
    * */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int [] help = new int[k];
        double [] ans = new  double[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            help[i] = nums[i];
        }
        Arrays.sort(help);
        if (k%2==0)
            ans[0] = (double)help[k/2]/2+(double) help[k/2-1]/2;//先除再加,防止溢出
        else ans[0] = (double)help[k/2];
        for (int i = k; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (help[j] == nums[i-k]) {
                    help[j] = nums[i];
                    while (j + 1 < k && help[j] > help[j + 1]) {
                        swap(help, j, j + 1);
                        ++j;
                    }
                    while (j - 1 >= 0 && help[j] < help[j - 1]) {
                        swap(help, j, j - 1);
                        --j;
                    }
                    if (k % 2 == 0)
                        ans[i - k + 1] =  ans[i - k + 1] = (double) help[k / 2]/2 +(double) help[k / 2 - 1] / 2;
                    else ans[i - k + 1] = (double) help[k / 2];
                    break;
                }
            }
        }
        return ans;
    }

}
