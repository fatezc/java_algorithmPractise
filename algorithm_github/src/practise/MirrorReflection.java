package practise;
/*
* 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。

正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。

返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/mirror-reflection
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MirrorReflection {
    /*
    将光线运动按纵横两个方向分解
     */
    public int mirrorReflection(int p, int q) {
        int row = 0,col = 0,flag = 1;
        while (true){
            row = p - row;
            col += flag*q;
            if (col>p){
                flag = -1;
                col = p-col % p;
            }
            if (col<0){
                flag = 1;
                col = -col;
            }
            if (row == 0 && col == p)
                return 2;
            if (row == p && col == 0)
                return 0;
            if (row == p && col == p)
                return 1;
        }
    }
}
