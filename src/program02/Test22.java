package program02;

public class Test22 {
//    时间复杂度O（logn）
    public static int getIndex(int[] arr, int target, boolean first){
        int start = 0;
        int end = arr.length -1 ;
        int mid = 0;
        while (start <= end) {
            mid = ((end - start)>>>2) + start;
            if(arr[mid] == target){
                if(!first){
                    if(mid == arr.length -1||arr[mid +1 ] != target){
                        return mid;
                    }else{
                        start = mid +1;
                    }
                }else{
                    if(mid == 0||arr[mid -1 ] != target){
                        return mid;
                    }else{
                        end = mid -1;
                    }
                }
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int NumOfTarget(int[] arr, int target){
        if(arr == null||arr.length == 0){
            System.out.println("输入数据不合法！");
            return -1;
        }
        int count =0;
        if(getIndex(arr, target,true) == -1){
            System.out.print("输入数据不存在！");
            return -1;
        }
        count = getIndex(arr, target, false) - getIndex(arr, target, true) + 1;
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,44,44,8,9,10};
        System.out.println(NumOfTarget(arr, 10));
        System.out.println(NumOfTarget(arr, 44));
        System.out.println(NumOfTarget(arr, 2));
        System.out.println(NumOfTarget(arr, 0));
    }
}
