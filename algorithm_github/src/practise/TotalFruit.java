package practise;
/*
* 在一排树中，第 i 棵树产生 tree[i] 型的水果。
你可以从你选择的任何树开始，然后重复执行以下步骤：

把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。

你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
用这个程序你能收集的水果总量是多少？
1 <= tree.length <= 40000
0 <= tree[i] < tree.length
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fruit-into-baskets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* 输入：[1,2,3,2,2]
输出：4
解释：我们可以收集 [2,3,2,2].
如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
*
* */
public class TotalFruit {
    /*
    用count记录每个篮子里的数量，num记录篮子里是哪种水果
    遍历，得到必须将tree[i]位置放到篮子里的值，每到tree[i]位置都进行判断：
            1.tree[i]==num1||num2,可以直接加到篮子里
            2.有篮子为空，可以直接加到篮子里
            3.其他，则不能直接加到篮子里，则显然tree[i-1]!=tree[i],则一个篮子放tree[i-1]，个数位从i-1位置往前值为tree[i-1]的个数（即help[i-1]），一个篮子放一个tree[i]
     */
    public int totalFruit(int[] tree) {
        if (tree == null)
            return 0;
        if (tree.length<=2)
            return tree.length;
        int count1 = 0,count2 = 0,num1 = -1, num2 = -1,ans = 2;
        int[] help = new int[tree.length];
        help[0] = 1;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == tree[i-1])
                help[i] = help[i-1]+1;
            else help[i] = 1;
        }
        if (tree[0] == tree[1]){
            num1 = tree[0];
            count1 = 2;
        }else {
            num1 = tree[0];
            num2 = tree[1];
            count1 = 1;
            count2 = 1;
        }
        for (int i = 2; i <tree.length ; i++) {
            if (tree[i] == num1){
                count1++;
            } else if (tree[i] == num2){
                count2++;
            }else if (count1 == 0){
                num1 = tree[i];
                count1 = 1;
            }else if (count2 == 0){
                num2 = tree[i];
                count2 = 1;
            }else {
                num1 = tree[i-1];
                count1 = help[i-1];
                num2 = tree[i];
                count2 = 1;
            }
            ans = Math.max(ans,count1+count2);
        }
        return ans;
    }
}
