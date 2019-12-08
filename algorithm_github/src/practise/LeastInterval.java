package practise;

import java.util.Comparator;
import java.util.PriorityQueue;


/*
* 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/task-scheduler
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        //统计各个任务出现次数
        int[] count = new int[26];
        for (char task : tasks) {
            count[task-'A']++;
        }
        //将count中不为0的值丢入大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0)
                heap.add(count[i]);
        }
        int ans = 0;
        int[] exeuce = new int[n+1];
        int i ;
        //每次从堆顶取出max(n+1,heap.size)个元素进行操作
        while (!heap.isEmpty()){
            for ( i = 0; i < n+1; i++) {
                if (!heap.isEmpty())
                    exeuce[i] = heap.poll();
                else break;
            }
            for (int j = 0; j < i; j++) {
                if (exeuce[j]>1)
                    heap.add(exeuce[j]-1);
            }
            if (heap.isEmpty())
                ans = ans +i;
            else ans = ans+ n+1;
        }
        return ans;
    }
}
