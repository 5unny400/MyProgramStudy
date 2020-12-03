package program04;

/**
 * 杨辉三角：
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 */
public class YanghuiTriangle {

    public static int YangTriangle(int x, int y){
        if(x < 0||y< 0||x < y){
            return -1;
        }
        if(y == 0||x == y){
            return 1;
        }else{
            return YangTriangle(x-1,y-1) + YangTriangle(x-1,y);
        }
    }
    public static void main(String[] args) {

        int x =5;
        int y =2;
        System.out.println("杨辉三角第"+x+"行"+y+"列："+YangTriangle(x-1,y-1));
        x = 1;
        y = 1;
        System.out.println("杨辉三角第"+x+"行"+y+"列："+YangTriangle(x-1,y-1));
        x = 5;
        y = 3;
        System.out.println("杨辉三角第"+x+"行"+y+"列："+YangTriangle(x-1,y-1));
    }
}
