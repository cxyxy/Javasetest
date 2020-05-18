package common.java_main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test_main {

    public static void main(String[] args) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get("E:\\test.txt")), StandardCharsets.UTF_8);
        System.out.println(content);
        //非字母分隔符-\\PL
        List<String> words = Arrays.asList(content.split("\\PL+"));

        //max/min
        Optional<String> max = words.stream().max(String::compareTo);
//        System.out.println("largest:  "+max.orElse(""));

        //findfrist,
        Optional<String> findfrist = words.stream().filter(word -> word.startsWith("d")).findFirst();
//        System.out.println(findfrist.orElse(""));

        //findAny----并行流的是时候
        Optional<String> findAny = words.stream().parallel().filter(word -> word.startsWith("d")).findAny();
//        System.out.println(findAny.orElse(""));

        //是否存在匹配anyMatch,allmatch,nonematch
        boolean d = words.stream().parallel().anyMatch(word -> word.startsWith("d"));
        boolean a= words.stream().parallel().allMatch(word -> word.startsWith("d"));
        System.out.println(d);
        System.out.println(a);
    }
}
