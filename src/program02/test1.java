package program02;

/**
 * 统计1在一组数据中出现的次数
 */
public class test1 {
    public static int NumOf1(int[] arr){
        if(arr.length == 0||arr == null){
            return Integer.MAX_VALUE;
        }

        int count = 0;
        for(int i =0;i < arr.length;i ++){
            int num = arr[i];
            while(num > 0){
                if(num%10 == 1){
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,11,114,1234};
        System.out.println("1在数组中出现的次数为： "+NumOf1(arr));
    }
}
