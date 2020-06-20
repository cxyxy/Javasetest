package common.reflection;

import java.lang.reflect.Method;

/**
 * User: Amos
 * Date: 2020/3/10
 * Time: 10:18
 */
public class Test4 {

    public static void main(String[] args) throws Exception {
        Person5 p = new Person5();
        Method m = p.getClass().getDeclaredMethod("setName", String.class);
        m.setAccessible(true);
        m.invoke(p, "Bob");
        System.out.println(p.name);
    }
}

class Person5 {
    String name;
    private void setName(String name) {
        this.name = name;
    }
}
