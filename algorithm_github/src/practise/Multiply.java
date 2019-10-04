package practise;
/*
* 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
* num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.length()==0||num2.length()==0)
            return "";
        if (num1.equals("0")||num2.equals("0"))
            return "0";
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            n1[i] = num1.charAt(i) -'0';
        }
        for (int i = 0; i < num2.length(); i++) {
            n2[i] = num2.charAt(i) - '0';
        }
        int temp;
        int[] ans = new int[num1.length()+num2.length()];
        for (int i = n1.length-1; i >=0 ; i--) {
            for (int k = n2.length-1,cur = ans.length-1-(n1.length-1-i)-(n2.length-1-k); k >= 0 ; k--,cur--) {
                temp = n1[i]*n2[k];
                ans[cur] += temp%10;
                if (temp>=0)
                    ans[cur-1] += temp/10;
            }
        }
        for (int i = ans.length-1; i >0 ; i--) {
            ans[i-1] += ans[i]/10;
            ans[i] = ans[i]%10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < ans.length; i++) {
           if (flag){
               stringBuilder.append(ans[i]);
           }
           else if (ans[i]>0){
               flag = true;
               --i;
           }
        }
        return stringBuilder.toString();
    }
}
