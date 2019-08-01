package common.decorativePattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 反射增强装饰模式的普适性
 *
 *
 * 定义一个接口Human
 定义一个被装饰的类Man
 定义一个装饰的抽象类，内部持有被装饰类的引用
 定义一个装饰的实现类
 * User: Amos
 * Date: 2019/4/18
 * Time: 16:17
 *
 * 通用的装饰模式，装饰行为让动态代理实现，装饰类和被装饰类的完全解耦
 */
public class DecorateAnimal implements Animal{
    //被包装的动物
    private Animal animal;

    //使用的包装器
    private Class<? extends Feature> clz;

    public DecorateAnimal(Animal animal, Class<? extends Feature> clz) {
        this.animal = animal;
        this.clz = clz;
    }

    @Override
    public void doStuff() {

        //具体包装行为
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(clz.newInstance(),args);
                animal.doStuff();
                return null;
            }
        };

        //当前加载器
        ClassLoader classLoader = getClass().getClassLoader();
        Feature proxy = (Feature) Proxy.newProxyInstance(classLoader, clz.getInterfaces(), handler);
        proxy.load();
    }


    public static void main(String[] args) {
//        Animal rat = new Rat();
////        rat.doStuff();
//        rat=new DecorateAnimal(rat,FlyFeature.class);
//        rat.doStuff();

        System.out.println(new Integer(1).equals(null));
    }
}
