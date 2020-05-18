package common.java_main;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//收集结果
public class Test_result {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3","3");
        //并行流希望顺序输出forEachOrdered,这个方法会丧失并行的优势
        list.stream().forEach(System.out::println);

        //转数组
        String[] strings = list.stream().toArray(String[]::new);

        List<String> collect = list.stream().collect(Collectors.toList());
        Set<String> collect1 = list.stream().collect(toSet());

        TreeSet<String> collect2 = list.stream().collect(Collectors.toCollection(TreeSet::new));

        //字符串
        String collect3 = list.stream().collect(Collectors.joining(","));
//        System.out.println(collect3);


        ArrayList<User> users = new ArrayList<User>() {{
            add(new User("A", 1));
            add(new User("B", 3));
            add(new User("C", 2));
        }};

        //list--》转化
        Map<Integer, String> collect4 = users.stream().collect(Collectors.toMap(User::getAge,User::getName));
//        for (Map.Entry<Integer,String> entry:collect4.entrySet()){
//            System.out.println(entry.getKey()+"+---"+entry.getValue());
//        }

        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
//        Map<String, String> collect5 = availableLocales.collect(Collectors.toMap(Locale::getDisplayLanguage,
//                l -> l.getDisplayLanguage(l),
//                //  (exsitV, value) -> exsitV) 解决key冲突
//                (exsitV, value) -> exsitV));

//        for (Map.Entry<String,String> entry:collect5.entrySet()){
//            System.out.println(entry.getKey()+"+---"+entry.getValue());
//        }


        //每个国家的所有语音---分组
        Map<String, Set<String>> collect6 = availableLocales.collect(Collectors.toMap(Locale::getDisplayCountry,
                l -> Collections.singleton(l.getDisplayLanguage()),
                (a,b) -> {
                    HashSet<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }));

//        for (Map.Entry<String,Set<String>> entry:collect6.entrySet()){
//            System.out.println(entry.getKey()+"+---"+entry.getValue());
//        }


        //分群组和分区---简化上述实现
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//        Map<String, List<Locale>> collect5 = locales.collect(Collectors.groupingBy(Locale::getCountry));

        //partitioningBy 高级分组(分类断言函数)
        Map<Boolean, List<Locale>> collect5 = locales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));

//        for (Map.Entry<Boolean,List<Locale>> entry:collect5.entrySet()){
//            System.out.println(entry.getKey()+"+---"+entry.getValue());
//        }



        //下游收集器
        Stream<Locale> locales2 = Stream.of(Locale.getAvailableLocales());
//        Map<String, Set<Locale>> collect7 = locales2.collect(groupingBy(Locale::getCountry, toSet()));


        //counting() 计数
        Map<String, Long> collect7 = locales2.collect(groupingBy(Locale::getDisplayCountry, counting()));

//        for (Map.Entry<String, Long> entry:collect7.entrySet()){
//            System.out.println(entry.getKey()+"+---"+entry.getValue());
//        }



        //把某个的所有语音放到一个集合----mapping-.接受下游结果上的收集器
        Stream<Locale> locales3 = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> collect8 = locales3.collect(groupingBy(Locale::getDisplayCountry,
                mapping(Locale::getDisplayLanguage, toSet())));

//        for (Map.Entry<String, Set<String>> entry:collect8.entrySet()){
//            System.out.println(entry.getKey()+"+---"+entry.getValue());
//        }

        /**
         * function 接口，传入一个经过操作得到另一个值。值得到
         *
         * Supplier 接口 直接得到一个值
         *
         * Consumer 接口 接受参数，没有返回直接操作
         */

        Stream<Locale> locales4 = Stream.of(Locale.getAvailableLocales());
        Map<String, Optional<String>> collect9 = locales4.collect(groupingBy(Locale::getDisplayCountry,
                mapping(Locale::getDisplayLanguage, maxBy(Comparator.comparing(String::length)))));


        for (Map.Entry<String, Optional<String>> entry:collect9.entrySet()){
            System.out.println(entry.getKey()+"+---"+entry.getValue().orElse(""));
        }
    }
}
