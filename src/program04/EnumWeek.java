package program04;

/**
 * 枚举是可以定义构造函数的
 * 每一个枚举都继承于Java.lang.Enum
 *
 */
public class EnumWeek {
    /*enum WeekDay{
        Mon,Tues,Wed,Tur,Fri,Sta,Sun;       //枚举成员相当于类的实例(对象)
        WeekDay(){      //无参构造

        }
    }*/

    enum WeekDay1{
        //枚举成员相当于类的实例(对象)
        Mon(""),Tues(""),Wed(""),Tur(""),Fri(""),Sta(""),Sun("");       //枚举成员相当于类的实例

        private String name;
        //默认私有的构造函数，只是用于枚举成员的初始化
        private WeekDay1(String name){
            this.name = name;
        }

        public static void printWeekDay(int i){
            switch(i){
                case 1:
                    System.out.println(WeekDay1.Mon);
                    break;
                case 2:
                    System.out.println(WeekDay1.Tues);
                    break;
                default:
                    System.out.println("Others...");
                    break;
            }
        }
    }

}
