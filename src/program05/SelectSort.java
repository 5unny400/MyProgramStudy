package program05;

import java.util.Arrays;

/**
 * @ClassName : ${NAME}  //类名
 * @author: Shenxinyuan
 * @Date 9:57 2020/8/31 0031
 * @Param:
 * @return:
 * @Description //TODO选择排序
 **/
public class SelectSort {
    //选择排序
    //不稳定的排序算法举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，
    // 那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法
    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 5, 11, 4, 6};
//        selectSort(arr);
        optimizedSelectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //时间复杂度（O(n^2)）   空间复杂度（O(1)）
    //从待排序列选择最大或最小数据跟第一个交换
    public static void selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        } else {
            for (int i = 0; i < array.length; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    //升序
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    swap(i,minIndex,array);
                }
            }
        }
    }
    //从待排序列中选择最大值和最小值选择排列
    //时间复杂度（O(n/2)） 空间复杂度（O(1)）
    public static void optimizedSelectSort(int[] array){
        if (array == null || array.length == 0) {
            return;
        } else {
            for(int i =0;i<(array.length>>1);i++){
                int minIndex = i;
                int maxIndex = i;
                for(int j =i+1;j<=array.length-1-i;j++){
                    if(array[j]<array[minIndex]){
                        minIndex = j;
                        continue;
                    }
                    if(array[j]>array[maxIndex]){
                        maxIndex = j;
                    }
                }
                if(minIndex!=i){
                    swap(i,minIndex,array);
                }
                if(maxIndex!=i){
                    swap(array.length-1-i,maxIndex,array);
                }
            }
        }
    }
    public static void swap(int i , int minIndex,int[] array){
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
