package common.genericity;

public class TestGenericity {


//    public static void main(String[] args) {
////
////        TestClassGen<String, Integer> test = new TestClassGen<>();
////        test.setAge(1);
////        System.out.println(test.getAge());
////        TestClassGen.test("aaa");
//
//
//        Pair<Integer> p = new Pair<>(123, 456);
//        int n = add(p);
//        System.out.println(n);
//
//    }

    //使用通配符，设置上限
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //编译过不了，因为只能确定类型为Number,不能确定为Integer
//        p.setFirst(new Integer(first.intValue() + 100));
//        p.setLast(new Integer(last.intValue() + 100));
        return first.intValue() + last.intValue();
    }

    /**
     * 使用类似<? extends Number>通配符作为方法参数时表示：
     *
     * 方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
     *
     * 方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。
     *
     * 即一句话总结：使用extends通配符表示可以读，不能写。
     *
     * 使用类似<T extends Number>定义泛型类时表示：
     *
     * 泛型类型限定为Number以及Number的子类。
     */


    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
        //返回的是object ,不一定是Integer
        Object obj = p.getFirst();
    }

    /**
     * 因此，使用<? super Integer>通配符表示：
     *
     * 允许调用set(? super Integer)方法传入Integer的引用；
     *
     * 不允许调用get()方法获得Integer的引用。
     *
     * 唯一例外是可以获取Object的引用：Object o = p.getFirst()。
     *
     * 换句话说，使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。
     */


    /**
     * 对比extends和super通配符
     * 我们再回顾一下extends通配符。作为方法参数，<? extends T>类型和<? super T>类型的区别在于：
     *
     * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
     *
     * <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
     *
     * 一个是允许读不允许写，另一个是允许写不允许读。
     */
}
