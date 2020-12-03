package program02;

/**
 * 统计一个数字在有序数组(默认是一个升序数组)中出现的次数
 *方法一：直接挨个遍历
 * 方法二：二分查找该方法似乎时间复杂度还是O(n)，错误示例如下
 */
public class Test2 {
    public static int findIndex(int[] arr, int num){
        if(arr.length == 0||arr == null){
            System.out.println("输入数逐bu合法！");
            return Integer.MAX_VALUE;
        }

        int start = 0;
        int end = arr.length-1;
        int midIndex = ((end - start)>>>2) + start;
        while(start <= end){
            if(num == arr[midIndex]){
                return midIndex;
            }else if(num > arr[midIndex]){
                start = midIndex + 1;
            }else{
                end = midIndex - 1;
            }
            midIndex = ((end - start)>>>2) + start;
        }
        return Integer.MAX_VALUE;
    }

    public static int NumOfx(int arr[],int target){
        int count = 0;
        int index = findIndex(arr, target);
        int temp = index;
        if(index >0&&index <arr.length) {
            while(index < arr.length){
                index ++;
                if(arr[index] == arr[index-1]){
                    count++;
                }else{
                    break;
                }
            }
            while(temp > 0){
                temp--;
                if(arr[temp] == arr[temp + 1]){
                    count++;
                }else{
                    break;
                }
            }
        }else{
            return -1;
        }
        count++;
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,3,8,11,11,11,15,15,18,19};
        System.out.println(NumOfx(arr, 3));
        System.out.println(NumOfx(arr, 2));
        System.out.println(NumOfx(arr, 11));
    }
}
