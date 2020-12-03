package program04;

public class Hanoi {

    private static int count = 0;
    public static void hanoi(int level, char from, char inter, char to){
        //递归终止条件
        count++;
        if(level == 1){
            System.out.println("从"+from +"移动盘子"+level+"号到"+to);
            return ;
        }
        //递归调用
        //把level-1个盘子从from移动到inter，不是一次性的过程
        hanoi(level-1, from, to, inter);
        System.out.println("从"+from +"移动盘子"+level+"号到"+to);
        //从inter移动到to，
        hanoi(level-1, inter, from, to);
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println("汉诺塔移动如下：");
        hanoi(n, 'x', 'y', 'z');
        System.out.println("一共移动了"+count+"次！");
    }
}
