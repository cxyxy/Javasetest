package common.lambda;

import java.util.Arrays;

/**
 * User: Amos
 * Date: 2020/3/12
 * Time: 13:59
 */
public class Test1 {


    //方法签名只看参数类型和返回类型，不看方法名称，也不看类的继承关系
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, Test1::cmp);
        System.out.println(String.join(", ", array));
    }

    ///因此，所谓方法引用，是指如果某个方法签名和接口恰好一致，就可以直接传入方法引用。

//    因为Comparator<String>接口定义的方法是int compare(String, String)，和静态方法int cmp(String, String)相比，除了方法名外，方法参数一致，返回类型相同，因此，我们说两者的方法签名一致
    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }


    /***
     * 不但可以编译通过，而且运行结果也是一样的，这说明String.compareTo()方法也符合Lambda定义。

     观察String.compareTo()的方法定义：

     public final class String {
     public int compareTo(String o) {
     ...
     }
     }
     这个方法的签名只有一个参数，为什么和int Comparator<String>.compare(String, String)能匹配呢？

     因为实例方法有一个隐含的this参数，String类的compareTo()方法在实际调用的时候，第一个隐含参数总是传入this，相当于静态方法：

     public static int compareTo(this, String o)
     */


    /**
     * FunctionalInterface允许传入：

     接口的实现类（传统写法，代码较繁琐）；
     Lambda表达式（只需列出参数名，由编译器推断类型）；
     符合方法签名的静态方法；
     符合方法签名的实例方法（实例类型被看做第一个参数类型）；
     符合方法签名的构造方法（实例类型被看做返回类型）。
     FunctionalInterface不强制继承关系，不需要方法名称相同，只要求方法参数（类型和数量）与方法返回类型相同，即认为方法签名相同
     */


    /**
     * Stream提供的常用操作有：

     转换操作：map()，filter()，sorted()，distinct()；

     合并操作：concat()，flatMap()；

     并行处理：parallel()；

     聚合操作：reduce()，collect()，count()，max()，min()，sum()，average()；

     其他操作：allMatch(), anyMatch(), forEach()
     */
}
