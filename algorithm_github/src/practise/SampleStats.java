package practise;
/*
* 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。

我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。

我们先来回顾一下中位数的知识：

如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/statistics-from-a-large-sample
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SampleStats {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        int num=0,zhongshu = 0,max = count.length-1,min = 0;
        long sum = 0;
        while (count[min] == 0) ++min;
        while (count[max] == 0)--max;
        for (int i = min; i <=max ; i++) {
            if (count[i]>count[zhongshu]) zhongshu = i;
            num += count[i];
            sum = sum + count[i]*i;
        }
        /*
        求中位数
         */
        double mid=0;
        int help = (num+1)/2;
        for (int i = min; i <max ; i++) {
            if (count[i]<help){
                help -= count[i];
            }else {
                mid = i;
                if (count[i] == help && num%2==0){
                    while (count[i+1] == 0) ++i;
                    mid = (mid+i+1)*1.0/2;
                }
                break;
            }
        }
        ans[0] = min;
        ans[1] = max;
        ans[2] = (double)sum/num;
        ans[3] = mid;
        ans[4] = zhongshu;
        return ans;
    }
}
