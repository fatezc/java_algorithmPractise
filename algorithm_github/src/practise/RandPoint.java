package practise;
/*
* 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。

说明:

输入值和输出值都将是浮点数。
圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
圆周上的点也认为是在圆中。
randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-random-point-in-a-circle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

/*
在一个刚好把该圆圈住的正方形里随机采样,如果是在圆内则采用,如果不是则继续,这样可保证完全随机
 */
public class RandPoint {
    private double r;
    private double x;
    private double y;
    public RandPoint(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    public double[] randPoint() {
        double random_1 = Math.random()*2-1;//生成-1~1之间的数
        double random_2 = Math.random()*2-1;
        while (random_1*random_1 + random_2*random_2>= 1){
            random_1 = Math.random()*2-1;
            random_2 = Math.random()*2-1;
        }
        return new double[]{x + random_1*r,y+random_2*r};
    }
}
