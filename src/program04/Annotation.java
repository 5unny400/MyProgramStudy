package program04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注释
 * java类库中定义的注释类型
 * 3个 java lang
 * 4个 java lang.annotation
 * @Override       //存在于编译期间  标记注解
 * @Deprecated      //本意：抛弃丢弃；  标记注解  丢弃当前方法 ；为了向前兼容jdk
 * @SuppressWarnings   //修饰构造器
 * 该注释有一个方法，该方法与注释的参数对应，带一个参数（字符串数组）
 * 数组的取值一般有以下几种
 * a.uncheked  执行力未检查的转换时的警告
 * b.deprecation  使用了过时的类或方法的警告
 * c.faultThrough switch...case语句中没有break语句
 * d.path  在类路径，源文件可能不存在时的警告
 * e.finnaly  任何finnaly字句不能正常执行
 * f：all    出现以上的情况都会出现警告
 *
 * @Retention   作用域
 *   RetentionPolicy 表示注释的作用域
 *   CLASS    class仅文件中存在
 *   SOURCE      仅编译时存在
 *   RUNTIME  存在整个周期
 *
 * @Documented  修饰的内容转为一个文档存在 javadoc中
 *
 * @Target      修饰目标的类型
 *   ElementType表示注释修饰的类型
 *   type 类/接口/枚举
 *   Field字段
 *   Method方法
 *   Parameter 参数
 *   Constructor 构造函数
 *   local_variable 局部变量
 *
 * @Inherited   继承  修饰自定义的注解  被他修饰的注解具有继承性
 *
 * Annotation  接口
 *
 * 自定义注解
 *   修饰符 + @interface + 注释名称{
 *   //权限只能是public
 *   //返回值类型（八中基本类型 选取对应的）
 *       String name();
 *       int id();
 *   }
 */

@Target(ElementType.TYPE)       //注释类型  类/接口/枚举
@Retention(RetentionPolicy.RUNTIME)        //注释作用域 运行的整个周期
@Inherited          //继承性
@interface InheritedTest{

}

@InheritedTest
class InheritedFather {
    public InheritedFather() {
        System.out.println("father: "+InheritedFather.class.isAnnotationPresent(InheritedTest.class));
    }
}

class InheritedSon extends InheritedFather{
    public InheritedSon(){
        System.out.println("Son: "+InheritedSon.class.isAnnotationPresent(InheritedTest.class));
    }
}


abstract class People{
    private String name;
    abstract public String funtion();

    @Deprecated
    public void getName(){

    }
}

class OverrideTest extends People{
    @Override
    public String funtion(){
        System.out.println("继承抽象类必须重写抽象法方法！");
        return null;
    }
}

class Mystack<T>{

    private T[] element;

    @SuppressWarnings("unchecked")
    public Mystack(){
        element = (T[])new Object[10];
    }
}
public class Annotation{

    public static void main(String[] args) {

//        @Target()
//        @Annotation
        InheritedFather father = new InheritedFather();
        InheritedSon son = new InheritedSon();
    }
}