package common.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * User: Amos
 * Date: 2020/3/10
 * Time: 15:18
 */
public class Test1 {

    //ByteArrayInputStream实际上是把一个byte[]数组在内存中变成一个InputStream，虽然实际应用不多，但测试的时候，可以用它来构造一个InputStream
//    public static void main(String[] args) throws IOException {
//        byte[] data = { 72, 101, 108, 108, 111, 33 };
//
//        //try source
//        try (InputStream input = new ByteArrayInputStream(data)) {
//            int n;
//            while ((n = input.read()) != -1) {
//                System.out.println((char)n);
//            }
//        }
//    }


    public static void main(String[] args) throws IOException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes("UTF-8"));
            output.write("world!".getBytes("UTF-8"));
            data = output.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));
    }

}
