package program01;

/**
 * 数组中重复的数字
 *      0~n-1
 *  1)排序 在比较相邻位置
 */
public class ArrayList {

    public static void bubbleSort(int[] arr){
        //判断参数合法性
        if(arr == null || arr.length == 0){
            return;
        }
        boolean label = true;
//        时间复杂度 O(n^2)          空间复杂度：O(1)
        for(int i =0;i<arr.length - 1;i++){
            for(int j = 0;j < arr.length-1-i;j ++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    label = false;
                }
            }
            if(label){
                return;
            }else{
                label = true;
            }
        }
    }

    public static void repeatNum(int[] arr){
        //判断参数合法性
        if(arr.length == 0 || arr == null){
            return ;
        }
        //题目所要求的所有数字必须在n~n-1之间
        for(int j =0;j<arr.length;j++){
            if(arr[j] < 0 ||arr[j] > arr.length - 1){
                System.out.println("不符合：0~n-1");
                return;
            }
        }
        //排序
        bubbleSort(arr);

        //判断ii+1位置的数字是否相等
        for(int i =0;i<arr.length - 1;i++){
            if(arr[i] == arr[i+1]){
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 4 , 6, 4, 0, 6, 0};
        repeatNum(arr);
//        System.out.println("hello！");
    }
}
