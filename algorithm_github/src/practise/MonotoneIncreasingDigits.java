package practise;
/*
* 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotone-increasing-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        //先将数字N转换成数组
        if (N<10)
            return N;
        int M = N;
        int i = 0;
        while (N>0){
            N = N/10;
            ++i;
        }
        int[] help = new int[i];
        for (int j = i-1; j >=0; j--) {
            help[j] = M%10;
            M = M/10;
        }
        boolean flag;
        //然后判断数组中是否存在不递增的位置，如32...，则将32....修改成2999...，然后再次判断，直到数组递增
        while (true){
            flag = true;
            for (int j = 0; j < i-1; j++) {
                if (help[j]>help[j+1]){
                    flag = false;
                    help[j]--;
                    for (int k = j+1; k < i ; k++) {
                        help[k] = 9;
                    }
                }
            }
            if (flag){
                int ans = 0;
                for (int j = 0; j <i ; j++) {
                    ans = ans*10 + help[j];
                }
                return ans;
            }
        }
    }
}
