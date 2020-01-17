package practise;

import java.util.Arrays;

public class TopVotedCandidate {
    int[] presons;
    int[] times;
    int[] help;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.presons = persons;
        this.times = times;
        int max_person =0;
        for (int person : persons) {
            max_person = Math.max(max_person,person);
        }
        //max_person+1个候选人
        int[] temp = new int[max_person+1];
        help = new int[times.length];
        help[0] = persons[0];
        temp[persons[0]]++;
        //用help[i]记录当考虑time[0:i]时应该返回哪个候选人
        for (int i = 1; i < help.length ; i++) {
            temp[persons[i]]++;
            if (temp[persons[i]] >= temp[help[i-1]])
                help[i] = persons[i];
            else help[i] = help[i-1];
        }
    }

    public int q(int t) {
        int left = 0,right = times.length-1;
        int mid;
        if (t>=times[times.length-1])
            left = times.length-1;
        //二分查找,找到t对应的应该考虑time[0到left]的left是多少
        while (left<right){
            mid = (left+right)/2;
            if ( times[mid]<=t && times[mid+1]>t){
                left = mid;
                break;
            }
            if (times[mid]<t) left = mid+1;
            else if (times[mid]>t) right = mid-1;
        }
        return help[left];
    }
}
