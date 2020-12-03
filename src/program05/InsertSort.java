package program05;

import java.util.Arrays;

/**
 * @ClassName : ${NAME}  //类名
 * @author: Shenxinyuan
 * @Date 10:36 2020/8/31 0031
 * @Param:
 * @return:
 * @Description //TODO插入排序
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 8, 9, 4, 4, 7, 0, 3};
        inserSort(arr);
//        optimizedInsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //空间复杂度（O(1)）   时间复杂度(O(n^2))
    //稳定的排序算法（判断方法，相同的数值排序后的相对位置是否发生改变）
    //最佳情况下时间复杂度趋近于O(n)
    public static void inserSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                int j;
                for (j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        break;
                    }
                }
                //挪数据(我采用的是交换的方式,这样就不用再次操作放数据，虽然这样代码简洁但是效率相对降低)
                for (int k = i - 1; k >= j; k--) {
                    swap(k + 1, k, arr);
                }
                //
            }
        }
    }

    //寻找有序序列中比下一个值小的前边插入，边找边挪数据，提高了效率，但是时间复杂度没变
    //越有序越快
    public static void optimizedInsertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                int j;
                int temp = arr[i];
                for (j = i - 1; j >= 0; j--) {
                    if (arr[j] <= temp) {
//                        arr[j + 1] = temp;
                        break;
                    } else {
                        //移动数据ing
                        arr[j + 1] = arr[j];
                        /*if (j == 0) {
                            arr[j] = temp;
                        }*/
                    }
                }
                arr[j + 1] = temp;      //精辟
            }
        }
    }

    public static void swap(int i, int minIndex, int[] array) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
