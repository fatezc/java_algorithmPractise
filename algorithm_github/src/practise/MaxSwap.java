package practise;

/*
* 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
* */
public class MaxSwap {
    public int maximumSwap(int num) {
        char[] s = ("" + num).toCharArray();
        int max;
        for (int i = 0; i < s.length; i++) {
            max = i;
            //找到比s[i]大的最后面的位置j,将其与i位置交换
            for (int j = i + 1; j < s.length; j++) {
                if (s[j] >= s[max])
                    max = j;
            }
            if (s[max] > s[i]) {
                char temp = s[i];
                s[i] = s[max];
                s[max] = temp;


                return Integer.parseInt(new String(s));
            }
        }
        return num;
    }
}
