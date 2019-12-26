package practise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
* 1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
所有房间中的钥匙数量总计不超过 3000。
* */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /*
        bfs,用一个set来存储已经打开的房间，用一个list来存储现有的钥匙,用一个viseted来加快查找到指定房间的速度。
         */
        Set<Integer> set = new HashSet<>();
        List<Integer>[] visited = new List[3000];
        int i = 0;
        for (List<Integer> room : rooms) {
            visited[i++] = room;
        }
        List<Integer> list = new LinkedList<>();
        list.add(0);
        while (!list.isEmpty()){
            Integer integer = list.get(0);
            set.add(integer);
            list.remove(0);
            if (visited[integer]!=null){
                for (Integer room : visited[integer]) {
                    list.add(room);
                }
                visited[integer] = null;
            }
        }
        return set.size() == rooms.size();
    }
}
