package common.java_main;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get("E:\\test.txt")), StandardCharsets.UTF_8);
        System.out.println(content);
        //非字母分隔符-\\PL
        List<String> words = Arrays.asList(content.split("\\PL+"));
        long count=0;
        for (String word:words){
            if(word.length()>4)
                System.out.println(word);
                count++;
        }
        System.out.printf("大小"+count);


        //java8
        //顺序流
        long count1 = words.stream().filter(word -> word.length() > 4).count();
        System.out.println("8大下"+count1);
        //并行流
        long count2 = words.parallelStream().filter(word -> word.length() > 4).count();
        System.out.println("9大下"+count2);


        Stream<String> split = Stream.of(content.split("\\PL"));

        //无限流
        Stream.generate(()->"Echo");
        Stream.generate(Math::random);

        //无限序列
        Stream.iterate(BigInteger.ZERO,n->n.add(BigInteger.ONE));

        //正则返回流
        Stream<String> stringStream = Pattern.compile("\\PL").splitAsStream(content);

        //返回流，返回文件带所有行的流
        Stream<String> lines = Files.lines(Paths.get("E:\\test.txt"));


    }
}
