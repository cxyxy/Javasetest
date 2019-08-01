package common.proxy.DycProxy;

import common.proxy.staticproxy.Animal;
import common.proxy.staticproxy.Cat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: Amos
 * Date: 2019/4/18
 * Time: 17:07
 */
public class DyProxy implements InvocationHandler{
        private Animal animal;
        public DyProxy(Animal animal) {
            this.animal = animal;
        }

        //增强方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("大家好！");
            method.invoke(animal,args);
            System.out.println("溜了!");
            return null;
        }

    public static void main(String[] args) {
        Animal cat = new Cat();
        DyProxy dyProxy = new DyProxy(cat);
        //返回代理实例
        Animal animal = (Animal) Proxy.newProxyInstance(cat.getClass().getClassLoader(), cat.getClass().getInterfaces(), dyProxy);
        animal.doSys();
    }
}
