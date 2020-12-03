package program02;

import java.util.Arrays;

public class Test3 {
    public static int getCharCount(char[] ch, char src){
        int count =0;
        for(int i =0;i<ch.length;i++){
            if(src == ch[i]){
                count++;
            }
        }
        return count;
    }

    public static String replaceSpace(String strs, char src, String aim){
        //参数的合法性
        if(strs == null|| strs.length() == 0){
            return null;
        }
        if(aim == null||aim.length() == 0){
            return null;
        }

        char[] ch = strs.toCharArray();
        int srcLastIndex = ch.length-1;
        int num = aim.length();
        char[] aimChar = aim.toCharArray();
        int count = getCharCount(ch, src);
        ch = Arrays.copyOf(ch, ch.length + count*(num-1));

        int i = srcLastIndex;
        int j = ch.length -1;
        while(i >=0&& j>=0){
            if(ch[i] == src){
                for(int k=num-1;k >= 0;k--){
                    ch[j--] = aimChar[k];
                }
                i--;
            }else{
                ch[j--] = ch[i--];
            }
        }
        String s = new String(ch);
        return s;
    }

    public static void main(String[] args) {
        String str = "We are family！";
        System.out.println(replaceSpace(str, ' ', "%20"));
    }
}
