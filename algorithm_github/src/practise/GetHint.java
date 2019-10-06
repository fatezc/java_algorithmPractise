package practise;

import java.util.HashMap;
import java.util.Map;

/*
* 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。

请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。

请注意秘密数字和朋友的猜测数都可能含有重复数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bulls-and-cows
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处.
* 示例：
* 输入: secret = "1807", guess = "7810"

输出: "1A3B"

解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。

* */
public class GetHint {
    public String getHint(String secret, String guess) {
        if (secret == null||guess==null||secret.length()==0)
            return secret;
        char[] chars_secret = secret.toCharArray();
        char[] chars_guess = guess.toCharArray();
        int bull = 0,cow = 0;
        for (int i = 0; i < chars_guess.length; i++) {
            if (chars_guess[i] == chars_secret[i]){
                bull++;
                chars_guess[i] = '*';
                chars_secret[i] = '*';
            }
        }
        Map<Character,Integer> map_secret = new HashMap<>();
        for (int i = 0; i < chars_secret.length; i++) {
            if (map_secret.containsKey(chars_secret[i]))
                map_secret.put(chars_secret[i],map_secret.get(chars_secret[i])+1);
            else map_secret.put(chars_secret[i],1);
        }
        for (int i = 0; i < chars_guess.length; i++) {
            if (chars_guess[i]!='*'){
                if (map_secret.containsKey(chars_guess[i])&&map_secret.get(chars_guess[i])>0){
                    cow++;
                    map_secret.put(chars_guess[i],map_secret.get(chars_guess[i])-1);
                }
            }
        }
        String ans = "";
        ans +=bull+"A"+cow+"B";
        return ans;
    }
}
