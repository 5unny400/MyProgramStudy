package program01;

/**
 * 1 2 8 9
 * 2 4 10 11
 * 4 7 12 13
 * 6 8 15 17
 *
 */
public class TwiceArray {
    public static boolean Search(int[][] arr, int target){
//      判断数据合法性
        if(arr == null || arr.length == 0){
            return false;
        }
//        从右上角开始
        int row =0;
        int col = arr.length - 1;

        while(row <= arr.length && col >= 0){
            if(target == arr[row][col]){
                return true;
            }else if(target > arr[row][col]){
                //往下走
                row++;
            }else{
                //往左走；
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},
                {2,4,10,11},
                {4,7,12,13},
                {6,8,15,17}};
        System.out.println(Search(arr, 1));
        System.out.println(Search(arr, 2));
        System.out.println(Search(arr, 3));
    }
}
