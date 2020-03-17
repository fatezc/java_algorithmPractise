package practise;
/*
* 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

并返回一个包含给定查询 queries 所有结果的数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class XorQueries {
    /*
    xor[left:right] = xor[0:left-1] ^ xor[0:right]
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        //数组xor[i]表示arr[0:i-1]的异或结果
        int[] xor = new int[arr.length+1];
        for (int i = 1; i <xor.length ; i++) {
            xor[i] = xor[i-1]^arr[i-1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = xor[queries[i][0]] ^ xor[queries[i][1]+1];
        }
        return ans;
    }
}
