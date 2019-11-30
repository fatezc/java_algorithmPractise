package practise;

import java.util.HashSet;
import java.util.LinkedList;

/*
* 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/beautiful-arrangement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CountArrangement {
    private LinkedList<Integer> list;
    private int ans;
    private int n;
    //回溯算法
    public int countArrangement(int N) {
        ans = 0;
        n = N;
        list = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            Integer remove = list.remove(0);
            backtrace(1,remove);
            list.add(remove);
        }
        return ans;
    }
    public void backtrace(int cur, int num){
        if (num% cur !=0 && cur %num !=0)
            return;
        if (cur == n)
            ans++;
        else {
            for (int i = 0; i < list.size(); i++) {
                Integer remove = list.remove(0);
                backtrace(cur+1,remove);
                list.add(remove);
            }
        }
    }
    //下面是官方题解
    /*
    *  int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

作者：LeetCode
链接：https://leetcode-cn.com/problems/beautiful-arrangement/solution/you-mei-de-pai-lie-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
}
