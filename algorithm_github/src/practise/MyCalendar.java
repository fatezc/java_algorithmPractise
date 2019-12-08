package practise;

import java.util.TreeMap;
/*
* 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。

MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。

当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。

每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。

请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/my-calendar-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MyCalendar {
    private TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (map.ceilingKey(start) != null && end>map.ceilingKey(start))
            return false;
        if (map.floorKey(start)!=null && map.get(map.floorKey(start))>start)
            return false;
        map.put(start,end);
        return true;
    }
}
