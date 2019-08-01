package common;

import java.util.List;

/**
 * User: Amos
 * Date: 2019/4/18
 * Time: 14:05
 */
public class GenericityTest {

    /**
     * 编译失败，在写的时候不确定元素类型,
     *         public static void write(List<? extends Number> list){
     *           list.add(1);
     *            }
     * @param list
     * 写的时候  确定下线
     */
    public static void write(List<? super Number> list){
        list.add(1);
        list.add(1.0);
        list.add(1L);
      }

    public static <E> void read1(List<? super E> list){
        for (Object object:list){

        }
    }

    /**
     * 读的时候使用上线
     * @param list
     * @param <E>
     */
    public static <E> void read(List<? extends E> list){
        for (E e:list){

        }
    }
}
