package MyLeetCode.test01;

import java.util.Arrays;

/**
 * P179
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public Solution(){}
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String numsToWord[] = new String[n];
        for(int i=0;i<n;i++){
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //compareTo()方法比较的时候是按照ASCII码逐位比较的
        //通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        //所以[3,30,34]排序后变为[34,3,30]
        //[233，23333]排序后变为[23333，233]
        //??????????????????????????
        Arrays.sort(numsToWord,(a, b)->{
            return (b+a).compareTo(a+b);
        });
        //如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if(numsToWord[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(numsToWord[i]);
        }
        return sb.toString();
    }
}

//作者：wang-qiang-ustb
//        链接：https://leetcode-cn.com/problems/largest-number/solution/java-jiang-shu-zu-zhuan-hua-wei-zi-fu-ch-ikrv/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


/**
 * ClassName:    demo01
 * Package:    MyLeetCode.test01
 * Description:
 * Datetime:    2021/4/13 0013   20:14
 * Author: 沈新源
 */
public class demo01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,30,34,5,9};
        System.out.println(solution.largestNumber(nums));

    }
}
