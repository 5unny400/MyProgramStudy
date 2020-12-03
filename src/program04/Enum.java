package program04;

//定义枚举类型
    enum Week{Mon,Tues,Wed,Thur,Fri,Sat,Sun};
//    可以用枚举类型名引用其中的常量，比如Week.Mon;
//      编译当前文件，枚举类型对应一个Week.java文件，说明枚举类型在编译时会生成一个相关类
public class Enum {
    public static void main(String[] args) {

        for(int i =0;i<Week.values().length;i++){
            System.out.print(Week.values()[i]+" ");
        }
        System.out.println();
        System.out.println("--------------------------");
        for(Week w:Week.values()){
            System.out.print(w+" ");
        }

        System.out.println();
        System.out.println(Week.valueOf("Mon"));    //将字符串转为一个枚举类型变量
        System.out.println(Week.valueOf("Mon").compareTo(Week.Tues));
        System.out.println(Week.Thur.ordinal());

        Week w = Week.Mon;
        switch(w){
            case Mon:
                System.out.println("今天星期一！");
                break;
            case Tues:
                break;
            case Thur:
                break;
            case Wed:
                break;
            case Fri:
                break;
            case Sat:
                break;
            case Sun:
                break;
        }
    }
}
