package practise;
/*
* 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Rand10 {
    public int rand7() {
        return (int)Math.random()*7+1;
    }
    //
    public int rand10() {
        int a=rand7() ,b=rand7();
        /*
        两次取rand7，则（a,b）可以等概率的取到（1,1）、（1,2）....（7,7）共49种情况
        反复取a,b，使a和b在前40种情况内，然后每4个情况对应一个数即可
         */
        while (a == 7 || (a == 6 && b>5)){
            a = rand7();
            b = rand7();
        }
        int ans = (a-1)*7 + b;
        if (ans %4 == 0)
            return ans /4;
        else return ans/4+1;
    }
}
