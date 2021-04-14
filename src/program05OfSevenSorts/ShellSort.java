package program05OfSevenSorts;

import java.util.Arrays;

/**
 * @ClassName : ${NAME}  //类名
 * @author: Shenxinyuan
 * @Date 13:14 2020/8/31 0031
 * @Param:
 * @return:
 * @Description //TODO希尔排序
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {10, 8, 1, 0, 19,
                2, 4, 28, 30, 56,
                24, 9, 5, 15, 12,
                11, 44, 77};
        shellSortSort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @return void
     * @Author Shenxinyuan
     * @Description //TODO
     * @Date 13:46 2020/8/31 0031
     * @Param gap是间距
     **/
    //时间复杂度O(n^2)      空间复杂度（O(1)）
    //非稳定排序算法
    private static void shellSortSort(int[] arr, int gap) {
        while (gap >= 1) {     //直到间距为1，
            for (int i =0; i < arr.length; i ++) {      //这样是多个组并行排序，提高效率
                int j;
                int temp = arr[i];
                for (j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] <= temp) {
                        break;
                    } else {
                        arr[j + gap] = arr[j];
                    }
                }
                arr[j + gap] = temp;      //精辟
            }
            gap--;
        }
    }
}
