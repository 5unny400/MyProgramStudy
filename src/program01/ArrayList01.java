package program01;

import java.util.Arrays;

public class ArrayList01 {
    public static int repeatNum(int[] arr){
        //判断数据合法性
        if(arr.length == 0 || arr == null){
            return Integer.MAX_VALUE;
        }
        //0~n-1
        for(int i =0;i < arr.length;i ++){
            if(arr[i] >arr.length-1||arr[i] < 0){
                return Integer.MAX_VALUE;
            }
        }
//        时间复杂度 O(n)          空间复杂度：O(1)
        for(int i =0;i< arr.length;i ++){
            while(arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }else{
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 0, 4};
        System.out.println(repeatNum(arr));
        System.out.println(Arrays.toString(arr));
    }
}
