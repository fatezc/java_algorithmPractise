package practise;

/*
* 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。

珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
1 <= piles.length <= 10^4
piles.length <= H <= 10^9
1 <= piles[i] <= 10^9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/koko-eating-bananas
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class EatBanana {
    /*先构造一个函数canEat来判断能不能在速度为k时在h个小时之前吃完piles[]堆香蕉
    * 然后按二分法依次判断,知道找到最小的满足情况的k
    * */
    public int minEatingSpeed(int[] piles, int H) {
       int l = 1,r = 1000000000;
       int mid;
       while (l<r){
           mid = (l+r)/2;
           if (canEat(piles,mid,H))
                r = mid;
           else l = mid+1;
       }
       return l;
    }
    //判断可以在P时间内由速度K吃完piles[]
    public boolean canEat(int[] piles,int k,int h){
        int times = 0;
        for (int pile : piles) {
            times += pile/k+(pile%k==0?0:1);
        }
        return times<=h;
    }
}


