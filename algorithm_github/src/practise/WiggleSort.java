package practise;

import java.util.Arrays;

/*
* 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。

示例:

输入: [5, 3, 1, 2, 3]
输出: [5, 1, 3, 2, 3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/peaks-and-valleys-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class WiggleSort {
    /*
    新建一个数组help复制nums并排序,
    然后将hlep中的数组按头一个尾一个的顺序插入nums中
     */
    public void wiggleSort(int[] nums) {
        int[] help = new int[nums.length];
        for (int i = 0; i < help.length; i++) {
            help[i] = nums[i];
        }
        Arrays.sort(help);
        int k = 0;
        for (int i = 0 , j = nums.length-1; i < j ; i++,j--) {
            nums[k++] = help[j];
            nums[k++] = help[i];
        }
        //nums.length为奇数的情况
        if (k == nums.length-1)
            nums[k] = help[help.length/2];
        return;
    }
}
