package practise;

import java.util.*;

public class Solution1 {
    private int[] arr;
    private int length;
    private int[] help;
    private  List<Integer> list;
    public Solution1(int[] nums) {
        arr = nums;
        length = nums.length;
        help = new int[nums.length];
        list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        for (int i = 0; i < help.length; i++) {
            help[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < length; i++) {
            arr[i] = help[i];
        }
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Collections.shuffle(list);//随机打乱
        for (int i = 0; i < length; i++) {
            arr[i] = help[list.get(i)];
        }
        return arr;
    }
}
