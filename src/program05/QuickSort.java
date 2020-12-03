package program05;
/**
 * @ClassName : ${NAME}  //类名
 * @author: Shenxinyuan
 * @Date 14:49 2020/8/31 0031
 * @Param:
 * @return:
 * @Description //TODO
 **/

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序：
 * 选择两个引用，选择一个基准
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 19, 0, 8, 100, 28, 7, 1, 15,7};
//        quickSort(arr);
        quickSortByWhile(arr);
        System.out.println(Arrays.toString(arr));
    }

    //
    private static void quickSort(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return ;
        } else {
            quick(arr,0,arr.length-1);
        }
    }
    private static void quick(int[] arr, int low, int high){
        int partition = partition(low,high,arr);
        //partition左边的数据都比它小，右边的数据都比他大
        //判断左边的数据大于1 个
        if(partition > low +1){
            quick(arr, low,partition-1);
        }
        //判断右边的数据大于1 个
        if(partition < high-1){
            quick(arr, partition+1,high);
        }
    }

    //以此划分过程时间复杂度是O(n)
    private static int partition(int low, int high, int[] arr) {
        int mark = arr[low];
        while (low < high) {
            //从后往前找比基准数据小的元素
            while (arr[high] >= mark && low < high) {
                high--;     //high可能会越界
            }
            if (low == high) {
                break;
            }
            if(arr[high]<mark){
                arr[low] = arr[high];
            }
            //从后往前找比基准数据小的元素
            while (arr[low] <= mark && low < high) {
                low++;
            }
            if (low == high) {
                break;
            }
            if(arr[low]>mark) {
                arr[high] = arr[low];
            }
        }
        arr[low] = mark;
        return low;
    }

    //快排的循环实现
    private static void quickSortByWhile(int[] array){
        //参数合法性判断
        if(array == null||array.length==0){
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length-1);
        while(!stack.isEmpty()){
            int high = stack.pop();
            int low = stack.pop();
            //mark左边的数字都比他小，右边的数值都比他大
            int mid = partition(low,high,array);
            //保证partition后的徐磊长度大于一
            //判断左边序列的个数是否大于一
            if(mid > low+1){
                stack.push(low);
                stack.push(mid-1);
            }
            //判断右边序列的个数是否大于一
            if(mid < high-1){
                stack.push(mid+1);
                stack.push(high);
            }
        }
    }
    //快排的优化(退化成选择排序，相当于每次吧最小的数据放到第一个)
    //选择基准的时候可能会偏大，偏小
    private static void OptimizedQuickSort(int[] array){
        //见笔记。。。。
    }
}
