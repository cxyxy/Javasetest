package common.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * User: Amos
 * Date: 2019/7/11
 * Time: 10:44
 * vm args:-XX:+HeapDumpOnOutOfMemoryError -Xms20m -Xmx20m
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list =new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
