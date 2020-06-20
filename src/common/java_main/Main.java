package common.java_main;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //math

        for (int i = 0; i <10 ; i++) {
            //[0,1) 的随机数
//            double random = Math.random();
            int i1 = (int) ((Math.random()+1)*1000);
            System.out.println(i1);
        }

        System.out.println("----------------------");
        //创建一个新的随机数生成器。
        //Random(long seed)：使用单个 long 种子创建一个新的随机数生成器。
        //或者默认当前系统时间的毫秒数作为种子数://
        //r.nextInt(10); // 5,生成一个[0,10)之间的int
        Random r = new Random();
        for (int i = 0; i <100 ; i++) {
//            int i1 = r.nextInt(1000);
            int i2 = r.nextInt(899999) + 100000;
            System.out.println(i2);
        }


        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));

//        sr.nextInt();
    }
}
