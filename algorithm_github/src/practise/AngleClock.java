package practise;
/*
* 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
* */
public class AngleClock {
    public double angleClock(int hour, int minutes) {
        //将整个表盘分为12 * 60个单位
        int length = 12 * 60;
        //计算时针在哪个单位
        int l_hour = 60 * (hour%12) + minutes;
        //计算分针在哪个单位
        int l_minutes = 12 * minutes;
        //计算两个的差值
        int del = Math.max(l_hour,l_minutes) - Math.min(l_hour,l_minutes);
        if (del< length/2)
            return del*360.0/length;
        return (length - del)*360.0/length;
    }
}
