package practise;

import java.util.List;

//给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的数字完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
public class NextGreaterElement {
    /*
    我们需要从右往左找到第一对连续的数字 a[i]a[i] 和 a[i-1]a[i−1] 满足 a[i-1] < a[i]a[i−1]<a[i]。到当前位置位置位置，a[i-1]a[i−1] 右边的数字没办法产生一个更大的排列，因为右边的数字是降序的。所以我们需要重新排布 a[i-1]a[i−1] 到最右边的数字来得到下一个排列。

那么怎样排布能得到下一个更大的数字呢？我们想得到恰好大于当前数字的下一个排列，所以我们需要用恰好大于 a[i-1]a[i−1] 的数字去替换掉 a[i-1]a[i−1]，比方说我们让这个数字为 a[j]a[j]。

我们将 a[i-1]a[i−1] 和 a[j]a[j] 交换，我们现在在下标为 i-1i−1 的地方得到了正确的数字，但当前的结果还不是一个正确的排列。我们需要用从 i-1i−1 开始到最右边数字剩下来的数字升序排列，来得到它们中的最小排列。

作者：LeetCode
链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/xia-yi-ge-geng-da-yuan-su-iii-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if (i < 0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
