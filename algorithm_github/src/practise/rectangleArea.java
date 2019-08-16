package practise;
/*
* 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

每个矩形由其左下顶点和右上顶点坐标表示:
*   (A,B):第一个矩形左下角的点
*   (C,D):第一个矩形右上角
*   E,F,G,H同理
*   此外保证第一个矩形在第二个左边
* */
public class rectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ans = 0;
        //有重叠部分
        if (C-A+G-E>(long)Math.max(G,C)-(long)Math.min(A,E)&&D-B+H-F>((long)Math.max(D,H)-(long)Math.min(B,F)))
            ans -= (C-A+G-E-(Math.max(G,C)-Math.min(A,E)))*
                (D-B+H-F-(Math.max(D,H)-Math.min(B,F)));//重叠部分面积
        ans += (C-A)*(D-B)+(G-E)*(H-F);
        return ans;
    }
}
