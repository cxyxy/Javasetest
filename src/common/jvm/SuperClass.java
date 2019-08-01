package common.jvm;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段， 不会导致子类初始化
 **/
public class SuperClass {
    private int i=100;
    public SuperClass(){
        System.out.println("GOUZAO SuperClass init！ ");
    }
    {
        System.out.println("SuperClass init！ "+i);
    }

    static {
        System.out.println("static SuperClass init！ ");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    private int i=100;
    public SubClass(){
        System.out.println(" gouzao  SubClass init！ "+i);
    }
    {
        System.out.println("SubClass init！ ");
    }
    static {
        System.out.println("SubClass init！ ");
    }
}

/**
 * 非主动使用类字段演示
 **/
class NotInitialization {
    /**
     * 非主动使用类字段演示
     **/
//    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//    }
    /*被动使用类字段演示二：
*通过数组定义来引用类， 不会触发此类的初始化
**/
    public static void main(String[] args) {
        new SubClass();
    }
}