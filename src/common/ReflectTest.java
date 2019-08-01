package common;

import java.lang.reflect.Array;

/**
 * User: Amos
 * Date: 2019/4/18
 * Time: 14:47
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        //只是加载类,并不会产生实例，执行任何代码
//      Class.forName("common.Utils");

        //动态生成数组，专门维数组定义的api
        String[] strings = (String[]) Array.newInstance(String.class, 8);
    }
}
