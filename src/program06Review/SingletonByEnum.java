package program06Review;

public class SingletonByEnum {
    public static void main(String[] args) {
        EnumSingleton single = new EnumSingleton();
    }
}


//枚举单例模式获取对象
class EnumSingleton{
    public static EnumSingleton getInstance(){
        return Inner.INSTANCE.getInstance();
    }

    private enum Inner{
        INSTANCE;	//枚举实例
        private EnumSingleton singleton;//唯一的实例类对象EnumSingleton

        Inner(){
            singleton = new EnumSingleton();
        }
        private EnumSingleton getInstance(){
            return singleton;
        }
    }
}
