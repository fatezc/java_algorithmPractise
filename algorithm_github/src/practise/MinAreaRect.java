package practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
* 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。

如果没有任何矩形，就返回 0。
* */
public class MinAreaRect {
    public int minAreaRect(int[][] points) {
        /*
        两点一组做对角线，看看存不存在另外一条相应的对角线
        用set存储所有点，方便查找
         */
        if (points.length<4)
            return 0;
        HashSet<String> set = new HashSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            set.add(""+points[i][0]+"."+points[i][1]);
        }
        for (int i = 0; i < points.length -1; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1])
                    continue;
                    if (set.contains(""+points[i][0]+"."+points[j][1]) && set.contains(""+points[j][0]+"."+points[i][1]))
                   ans = Math.min(ans,Math.abs((points[i][0]-points[j][0])*(points[i][1]-points[j][1])));
            }
        }
        return ans<Integer.MAX_VALUE?ans:0;
    }
}
