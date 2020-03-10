package common.reflection;

import java.lang.reflect.Field;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Object p = new Person1("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        //不加无法获得private 的值
        //setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming
    }
}

class Person1 {
    private String name;

    public Person1(String name) {
        this.name = name;
    }
}
