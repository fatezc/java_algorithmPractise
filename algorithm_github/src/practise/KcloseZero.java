package practise;

/*
* 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KcloseZero {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length<=K)
            return points;
        int [][] ans = new int[K][2];
        PriorityQueue<Integer> prique  = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return points[o1][0]*points[o1][0]+points[o1][1]*points[o1][1]-
                 points[o2][0]*points[o2][0]-points[o1][2]*points[o1][2];
            }
        });
        for (int i = 0; i < points.length; i++) {
            prique.add(i);
        }
        for (int i = 0; i < K; i++) {
            ans[i][0] = points[prique.peek()][0];
            ans[i][1] = points[prique.poll()][1];
        }
        return ans;
    }
}
