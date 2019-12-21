package practise;
/*
* 编写一个遍历游程编码序列的迭代器。

迭代器由 RLEIterator(int[] A) 初始化，其中 A 是某个序列的游程编码。更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。

迭代器支持一个函数：next(int n)，它耗尽接下来的  n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。如果没有剩余的元素可供耗尽，则  next 返回 -1 。

例如，我们以 A = [3,8,0,9,2,5] 开始，这是序列 [8,8,8,5,5] 的游程编码。这是因为该序列可以读作 “三个八，零个九，两个五”。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rle-iterator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class RLEIterator {
    private int[][] help;
    private long[] sum;//不能定义为Long[]，会报空指针异常
    private long count;
    public RLEIterator(int[] A) {
        help = new int[A.length/2][2];
        sum = new long[help.length+1];
        count = 0L;
        for (int i = 0; i < A.length; i++) {
            help[i/2][i%2] = A[i];
        }
        for (int i = 0; i < help.length; i++) {
            sum[i+1] = sum[i] + help[i][0];
        }
    }

    public int next(int n) {
        count += n;
        if (count>sum[sum.length-1])
            return -1;
        return binarySearch();
    }
    public int binarySearch(){
        int left = 0,right = sum.length;
        int mid = (left+right)/2;
        while (sum[mid]<count || sum[mid-1]>=count){
            if (sum[mid]<count)
                left = mid+1;
            else right = mid;
            mid = (left+right)/2;
        }
        return mid-1 >=0?help[mid - 1][1]:-1;
    }
}
