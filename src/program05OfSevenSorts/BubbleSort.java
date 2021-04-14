package program05OfSevenSorts;

import java.util.Arrays;

/**
 * @ClassName : ${NAME}  //类名
 * @author:  Shenxinyuan
 * @Date 9:37 2020/8/31 0031
 * @Param: 
 * @return: 
 * @Description //TODO 冒泡排序
 **/
//两个相同的数据的相对位置是否发生改变
//稳定的排序算法
public class BubbleSort {
    //冒泡排序
    //稳定的排序算法
    //优化，置一个变量判断是否发生交换，每一趟都少遍历比较一个数
    public static void main(String[] args) {
        int[] arr = {1,2,9,5,11,4,6};
        bubblesort(arr);

        System.out.println(Arrays.toString(arr));
    }
    //空间复杂度（O(1)）   时间复杂度（O(n^2)）
    public static void bubblesort(int[] arr) {
        if(arr==null||arr.length == 0){
            return;
        }

        boolean label = true;
        //躺数
        for (int i = 0; i < arr.length-1&&label; i++) {
            label = false;
            for (int j = 0; j < arr.length - 1-i; j++) {
                //每一躺确定一个最大值，升序
                //每一躺所遍历比较的数一少一个
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    label = true;
                }
            }
        }
    }
}
