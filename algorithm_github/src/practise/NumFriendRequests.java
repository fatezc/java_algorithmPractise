package practise;

import java.util.Arrays;

/*
* 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。

当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
否则，A 可以给 B 发送好友请求。

注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 

求总共会发出多少份好友请求?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int left,right;
        for (int i = 0; i < ages.length; i++) {
            if (0.5*ages[i]+7>=ages[i])
                continue;
            right = i;
            /*
            下面查找right和left可以用二分
             */
            while (right+1<ages.length &&ages[right+1] == ages[right]) ++right;
            left = i;
            while (left-1>=0 && ages[left-1]>0.5*ages[i]+7) left--;
            ans += right-left;
        }
        return ans;
    }
}
