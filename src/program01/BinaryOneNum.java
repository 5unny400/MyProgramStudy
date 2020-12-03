package program01;

public class BinaryOneNum {
    public static int countNum(int x){
        int count = 0;
        while(x != 0){
            if(x % 2 != 0){
                count++;
            }
//            x /= 2;       这样的话负数结果不正确
            x >>>= 1;
        }
        return count;
    }
    public static int countNum1(int x){
        int count =0;
        while(x != 0){
            count++;
            x &= (x- 1);
        }
        return count;
    }
    public static int countNum2(int x){
        int count =0;
        while(x != 0){
            count++;
            x >>>= 1;
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(countNum(-1));
        System.out.println(countNum1(-1));
        System.out.println(countNum2(-1));
//        System.out.println(countNum(1));
    }
}
