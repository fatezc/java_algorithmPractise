package practise;

import java.util.Arrays;

/*
* 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。

返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-swap-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindSwapValues {
    /*
        将array1排序
        然后对于array2中的每个元素,在array1中二分查找是否有满足条件的那个数字
        tips:如果两个数组和的差值为奇数,则直接返回不存在
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        int del = 0;//del = sum(array1 - array2)
        for (int i : array1) {
            del+=i;
        }
        for (int i : array2) {
            del-=i;
        }
        if (Math.abs(del) % 2 == 1)
            return new int[0];
        del /= 2;
        for (int i : array2) {
            if (binaryfind(array1,i+del)){
                return new int[]{i+del,i};
            }
        }
        return new int[0];
    }
    public boolean binaryfind(int[] array1 , int val){
        int left = 0,right = array1.length-1,mid;
        while (left<=right){
            mid = (left+right)/2;
            if (array1[mid] == val)
                return true;
            if (array1[mid]<val)
                left = mid+1;
            if (array1[mid]>val)
                right = mid - 1;
        }
        return false;
    }
}
