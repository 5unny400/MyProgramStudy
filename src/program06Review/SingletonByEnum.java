package program06Review;

public class SingletonByEnum {
    public static void main(String[] args) {
        EnumSingleton single = EnumSingleton.getInstance();
        EnumSingleton single2 = EnumSingleton.getInstance();
        System.out.println(single);
        System.out.println(single2);

        //测试
//        Singletion4 singletion41 = new Singletion4();
//        Singletion4 singletion42 = new Singletion4();
//        System.out.println(singletion41);
//        System.out.println(singletion42);
    }
}


//枚举单例模式获取对象
class EnumSingleton {

    private EnumSingleton(){

    }
    public static EnumSingleton getInstance() {
        System.out.println("私有构造函数，创建单例的关键！");
        return Inner.INSTANCE.getInstance();
    }

    private enum Inner {
        INSTANCE;    //枚举实例
        private EnumSingleton singleton;//唯一的实例类对象EnumSingleton

        Inner() {
            System.out.println("内部类的实例块内部，调用外部类的私有构造方法！");
            singleton = new EnumSingleton();
        }

        private EnumSingleton getInstance() {
            System.out.println("返回创建的单例对象！");
            return singleton;
        }
    }
}
