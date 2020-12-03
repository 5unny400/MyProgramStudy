package program01;

import java.util.Arrays;

/**
 * 调整数组的顺序使奇数在前偶数在后
 *
 */
public class OddEvenNum {
    public static void swapNum(int[] arr){
        //维护参数的合法性
        if(arr == null ||arr.length == 0){
            return;
        }

        int start =0;
        int end = arr.length - 1;

        while(start < end){
            //向后start移动，直到当前的start指向偶数
            while(start < end&&(arr[start] & 0x1) != 0){
                start++;
            }
            //向前移动end引用，知道当前的end指向奇数
            while(start < end&& (arr[end] & 0x1) == 0){
                end--;
            }
            if(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,4,0,5,8,9,1,6};
        swapNum(arr);
        System.out.println(Arrays.toString(arr));
    }
}
