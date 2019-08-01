package common.proxy.staticproxy;

/**
 * User: Amos
 * Date: 2019/4/18
 * Time: 16:48
 *
 * 　　优点：可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。
 　　缺点：因为代理对象，需要实现与目标对象一样的接口，
 会导致代理类十分繁多，不易维护，同时一旦接口增加方法，则目标对象和代理类都需要维护。
 */
public class ProxyAnimal implements Animal{
    //要代理的实现类
    private Animal animal=null;

    public ProxyAnimal(Animal animal) {
        this.animal =animal;
    }

    public ProxyAnimal() {
        this.animal = new Cat();
    }

    @Override
    public void doSys() {
        System.out.println("前置增强!");
        animal.doSys();
        System.out.println("后置增强!");
    }

    public static void main(String[] args) {
        Animal cat = new ProxyAnimal();
        cat.doSys();
    }
}
