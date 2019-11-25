package practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。

如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reordered-power-of-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        long i = 1;
        char[] chars = String.valueOf(N).toCharArray();
        Arrays.sort(chars);
        String string = String.valueOf(chars);//存储N的最小字典序
        Set<String> help = new HashSet<>();
        while (i < Math.pow(10,10)){
            char[] chars1 = String.valueOf(i).toCharArray();
            Arrays.sort(chars1);
            //对每一个2的k次方，比较其最小字典序是否与N的相同
            if (string.equals(String.valueOf(chars1))){
                return true;
            }
            i = i*2;
        }
        return false;
    }
}
