package common.java_main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {

        Optional<String> hello = Optional.ofNullable("aaa");
        String result = hello.orElse("");
//        System.out.println(result);
        String s = hello.orElseGet(() -> Locale.getDefault().getDisplayName());
//        System.out.println(s);
//        hello.orElseThrow(IllegalAccessError::new);

       List<String> strings = new ArrayList<>();
//
//       Optional.empty().isPresent();
//        hello.isPresent(s->strings.add(s));

        //正确姿势
        hello.ifPresent(System.out::println);
        hello.ifPresent(strings::add);

//        System.out.println(strings.get(0));

        /**
         * //而不要下边那样
         * if (user.isPresent()) {
         *   System.out.println(user.get());
         * }
         */

        //map,可以级联的往下
        User aa = new User("AA", 1);
        Optional<User> user = Optional.ofNullable(aa);
        String defaultv = user.map(u -> u.getName())
                .map(name->name.toLowerCase())
                .orElse("默认");
        System.out.println(defaultv);

        /**
         * 而不是下面这样
         * User user = .....
         * if(user != null) {
         *   String name = user.getUsername();
         *   if(name != null) {
         *     return name.toUpperCase();
         *   } else {
         *     return null;
         *   }
         * } else {
         *   return null;
         * }
         */

        //filter

        Optional<User> user1 = user.filter(u -> u.getAge() >= 18);
        System.out.println(user1.orElse(new User("BB",18)));


        //flatMap flatMap方法与map方法类似，区别在于mapping函数的返回值不同
        // map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
        Optional<String> s1 = hello.flatMap((a) -> Optional.of(a.toUpperCase())).flatMap((b)->(Optional.of(b+"cc")));
        System.out.println(s1.orElse(""));
    }

}
