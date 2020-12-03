package program04;

public class Recursion {

    //默认升序
    public static int binarySearch(int[] arr, int low, int high, int target){
        if(target < 0){
            return -1;
        }
        if(low <= high) {
            int mid = ((high - low) >>> 1) + low;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, low, mid - 1, target);
            } else if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, high, target);
            }
        }
        return -1;
    }

    public static int Factorial(int n){
        if(n < 0){
            System.out.println();
            return -1;
        }
        if(n == 1){
            return 1;
        }else{
            return Factorial(n - 1)*n;
        }
    }

    public static int Fibo(int n){
        if(n < 0){
            System.out.println();
            return -1;
        }
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return Fibo(n - 1) + Fibo(n - 2);
        }

    }

    public static int optimizedFibo(int first, int second, int n){
        if(n < 0){
            System.out.println();
            return -1;
        }else if(n ==1 || n == 2){
            return 1;
        }else if(n == 3){
            return first + second;
        }else{
            return optimizedFibo(second, first + second, n-1);
        }
    }
    public static void main(String[] args) {

        System.out.println("4!：" + Factorial(4));
        System.out.println("斐波那契数列的第5项：" + Fibo(5));
        System.out.println("斐波那契数列的第5项(优化)：" + optimizedFibo(1,1, 5));
        System.out.println("斐波那契数列的第10项(优化)：" + optimizedFibo(1,1, 10));

        int[] arr = {0,1,2,3,4,5,6};
        System.out.println("递归，二分查找5的下标：" + binarySearch(arr,0,arr.length-1,5));
        System.out.println("递归，二分查找9的下标：" + binarySearch(arr,0,arr.length-1,9));

    }
}
