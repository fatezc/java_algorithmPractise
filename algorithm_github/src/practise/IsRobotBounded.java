package practise;
/*
* 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：

"G"：直走 1 个单位
"L"：左转 90 度
"R"：右转 90 度
机器人按顺序执行指令 instructions，并一直重复它们。

只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/robot-bounded-in-circle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsRobotBounded {
    /*
    因为只有四个方向,所以如果没办法在四次循环内走回远点,那么必然就会离开,反之则不会
     */
    public boolean isRobotBounded(String instructions) {
        int[][] help = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
       int[] cur = {0,0};
        int dir = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                if (instructions.charAt(j) == 'G'){
                    cur[0] += help[dir][0];
                    cur[1] += help[dir][1];
                }
                else if (instructions.charAt(j) == 'L')
                    dir = dir==0?3:dir-1;
                else dir = dir==3?0:dir+1;
            }
            if (cur[0] == 0 && cur[1] == 0)
                return true;
        }
        return false;
    }
}
