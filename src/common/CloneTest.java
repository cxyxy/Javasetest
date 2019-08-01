package common;

/**
 * User: Amos
 * Date: 2019/4/10
 * Time: 15:24
 */
public class CloneTest {

    public static void main(String[] args) {

        PersonClone personClone = new PersonClone("爸爸");
        PersonClone s1 = new PersonClone("大儿子",personClone);
        PersonClone s2 = s1.clone();
        s2.setName("小儿子");
        System.out.println(s1);
        System.out.println("---------------");
        System.out.println(s2);
        //修改大儿子的爸爸为干巴巴
        s1.getPerson().setName("干巴巴");
        System.out.println(s1);
        System.out.println("---------------");
        System.out.println(s2);
        //发现s1 S2 都是干巴巴，这是因为super.clone()默认的是浅拷贝
        //并不是把对象的属性值都都拷贝一份，基本类型是拷贝值，对象是拷贝地址引用。

        System.out.println(Long.parseLong(null));
    }


}
