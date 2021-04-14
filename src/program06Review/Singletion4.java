package program06Review;

public class Singletion4 {
    private Singletion4() {
    }

    public void f() {
        System.out.println("DNALI");
    }

    public static Singletion4 getInstance() {
        return ee.Singletion4.singletion4;
    }

    public enum ee {
        Singletion4;
        public Singletion4 singletion4;

        {
            singletion4 = new Singletion4();
        }
    }

    public static void main(String[] args) {
        Singletion4 singletion4 = Singletion4.getInstance();
        Singletion4 singletion44 = Singletion4.getInstance();

        System.out.println(singletion4);
        System.out.println(singletion44);

        //测试
//        EnumSingleton single = new EnumSingleton();
//        EnumSingleton single2 = new EnumSingleton();
//        System.out.println(single);
//        System.out.println(single2);
    }
}