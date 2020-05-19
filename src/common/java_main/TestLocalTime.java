package common.java_main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TestLocalTime {

    public static void main(String[] args) {

        //本地时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        boolean before = LocalDateTime.of(2020, 5, 19, 11, 5, 43).isAfter(LocalDateTime.of(2020, 5, 19, 11, 5, 43));
        System.out.println(before);


        //时区时间,本地时间-》时区时间
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Europe/Berlin"));
        System.out.println(zonedDateTime);
        //所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();



        //时间格式化--DateTimeFormatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);
        //转化为回
        LocalDateTime parse = LocalDateTime.parse(format,dateTimeFormatter);
        System.out.println(parse);
    }
}
