package program04;

public class Palindrome {

    public static boolean Palin(char[] arr, int low, int high){
        if(arr.length == 0||arr == null){
            return false;
        }
        if(low <= high){
            if(arr[low] == arr[high]) {
                if (low == high||high - low == 1) {
                    return true;
                } else {
                    return Palin(arr, low + 1, high - 1);
                }
            }else{
                return false;
            }
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        String s = "asdffdsa";
        String p = "asdjkdsa";
        char[] arr = s.toCharArray();
        char[] brr = p.toCharArray();
        System.out.println("是否是回文序列："+Palin(arr, 0 , arr.length-1));
        System.out.println("是否是回文序列："+Palin(brr, 0 , brr.length-1));
    }
}
