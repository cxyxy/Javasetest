package common.reflection;

import java.lang.reflect.Method;

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
