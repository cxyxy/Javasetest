package common.reflection;

import java.lang.reflect.Field;

public  class  Test3{
public static void main(String[] args) throws Exception {
        Person2 p = new Person2("Xiao Ming");
        System.out.println(p.getName()); // "Xiao Ming"
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p, "Xiao Hong");
        System.out.println(p.getName()); // "Xiao Hong"
    }
}

class Person2 {
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}