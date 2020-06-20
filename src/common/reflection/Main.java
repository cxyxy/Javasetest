package common.reflection;

import java.lang.reflect.Method;


/*<? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；

        <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。

           一个是允许读不允许写，另一个是允许写不允许读。
 */
public class Main {

    //多肽方法调用
    public static void main(String[] args) throws Exception {
        // 获取Person的hello方法:
        Method h = Person6.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Student6());
    }
}

class Person6 {
    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student6 extends Person6{
    @Override
    public void hello() {
        System.out.println("Student:hello");
    }
}
