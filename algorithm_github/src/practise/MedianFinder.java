package practise;

/*
* 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-median-from-data-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class MedianFinder {
    /*
    用一个小根堆来存储较大的一半的数字,一个大根堆来存储较小的一半的数字,并保证小根堆的size与大根堆相等或者多一个
    这样每次取中位数则只要考虑小根堆堆顶和大根堆堆顶
     */
    private PriorityQueue<Integer> smallheap;
    private PriorityQueue<Integer> bigheap;
    public MedianFinder() {
        smallheap = new PriorityQueue<>();
        bigheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }
    public void addNum(int num) {
        if (smallheap.size()>bigheap.size()){
            if (num>smallheap.peek()){
                bigheap.add(smallheap.poll());
                smallheap.add(num);
            }else {
                bigheap.add(num);
            }
        } else {
            if (bigheap.size()>0&&num<bigheap.peek()){
                smallheap.add(bigheap.poll());
                bigheap.add(num);
            } else
                smallheap.add(num);
        }
    }

    public double findMedian() {
        if (smallheap.size() == 0)
            return 0.0;
        if (smallheap.size() == bigheap.size())
            return (double)smallheap.peek()/2+(double)bigheap.peek()/2;
        return (double)smallheap.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
    }
}
