package common;

import java.util.ArrayList;

/**
 * User: Amos
 * Date: 2019/4/4
 * Time: 10:51
 * 静态变量的加载顺序,改变1和2的顺序,看看结果
 */
public class TestStatic {
    //1
    static {
        i=100;
    }
    //2
    private static int i=1;
    public static void main(String[] args) {
        System.out.println(i);

        new ArrayList(){};
    }


}
