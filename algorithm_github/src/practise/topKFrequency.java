package practise;

import java.util.*;


/*
* 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
* */
public class topKFrequency {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //先用hash表存储每个不同的num出现的次数,O(n)
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num:nums
        ){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        //再用一个小根堆来插入 O(nlogk)
        PriorityQueue<int[]> heap = new PriorityQueue<>( new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int key :
                hashMap.keySet()) {
            heap.add( new int[]{key, hashMap.get(key)});
            //保持堆中元素个数为k个
            if (heap.size()>k)
                heap.poll();
        }

       List<Integer> list = new LinkedList<>();
        for (int[] arr :
                heap) {
            list.add(arr[0]);
        }
        return list;
    }
}
