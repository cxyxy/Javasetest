package common.java_main;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//流转化流
public class TestMap_flatMap_filter {

    public static void main(String[] args) throws IOException {
//        Stream<String> words = Files.lines(Paths.get("E:\\test.txt"));
        String content = new String(Files.readAllBytes(Paths.get("E:\\test.txt")), StandardCharsets.UTF_8);
        System.out.println(content);
        //非字母分隔符-\\PL
        List<String> words = Arrays.asList(content.split("\\PL+"));

        //filter 按条件过滤
        Stream<String> stringStream = words.stream().filter(word -> word.length() > 4);
        stringStream.forEach(word-> System.out.println(word));
        System.out.println("--------------------------------------");
        //按某种方式转换map
        Stream<String> stringStream1 = words.stream().map(word -> word.toUpperCase());
        stringStream1.forEach(word-> System.out.println(word));
        System.out.println("--------------------------------------");

        //首字母
        Stream<String> stringStream2 = words.stream().map(word -> word.substring(0, 1));
        stringStream2.forEach(word-> System.out.println(word));
        System.out.println("--------------------------------------");

        Stream<Stream<String>> streamStream = words.stream().map(word -> letter(word));
        streamStream.forEach(s->s.forEach(s1 -> System.out.println(s1)));
        
        
        //链接流，把当前所有流中的所有元素合成一个
        Stream<String> stringStream3 = words.stream().flatMap(word -> letter(word));
    }

    public static Stream<String> letter(String s){
        List<String> strings = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            strings.add(s.substring(i,i+1));
        }
        return strings.stream();
    }
}
