package practise;

import java.util.Arrays;
//快速排序及其检验
public class QuickSort {
    //以arr[right]为基准将arr分为两部分
    public int Partition(int[] arr,int left,int right){
        if (arr == null||arr.length == 0||left<0||right>=arr.length)
            return -1;
        int small = left - 1;
        for (int i = left; i <right ; i++) {
            if (arr[i] < arr[right]){
                small++;
                if (small != i)
                    Swap(arr,small,i);
            }
        }
        Swap(arr,++small,right);
        return small;
    }
    public void Swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    public void quickSort(int[] arr,int left,int right){
        if (arr==null||arr.length==0)
            return;
        int small = Partition(arr,left,right);
        if (small>left)
            quickSort(arr,left,small-1);
        if (small<right)
            quickSort(arr,small+1,right);
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 5000; i++) {
            int arr[] = new int[(int)(Math.random()*30)+1];
            int arr1[] = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int)(Math.random()*20);
                arr1[j] = arr[j];
            }
          Arrays.sort(arr);
            new QuickSort().quickSort(arr1,0,arr1.length-1);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]!=arr1[j]){
                    System.out.println("flase");
                    throw new Exception("排序不等");
                }
            }
            System.out.println("true");
        }
    }
}
