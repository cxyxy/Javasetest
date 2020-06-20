package common.java_main;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

//抽取流连接流
public class Test_skip_limit {

    public static void main(String[] args) throws IOException {

        //产生100个随机数流
        Stream<Double> limit = Stream.generate(Math::random).limit(100);

        String content = new String(Files.readAllBytes(Paths.get("E:\\test.txt")), StandardCharsets.UTF_8);
        System.out.println(content);
        //非字母分隔符-\\PL
        List<String> words = Arrays.asList(content.split("\\PL+"));
        //跳过
        Stream<String> skip = words.stream().skip(1);

        //concat,第一个不可以是无限流否则后面的得不到处理
        Stream<String> concat = Stream.concat(letter("hello"), letter("word"));

        //distinct,去除重复
        Stream<String> distinct = Stream.of("H", "H", "L", "O", "O").distinct();
//        distinct.forEach(s-> System.out.println(s));


        //流排序sorted，一种用于操作comparable元素，一种接受comparator
        Stream<String> sorted = words.stream().sorted(Comparator.comparing(String::length).reversed());
        sorted.forEach(w-> System.out.println(w));


        //peek

    }

    public static Stream<String> letter(String s){
        List<String> strings = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            strings.add(s.substring(i,i+1));
        }
        return strings.stream();
    }
}
