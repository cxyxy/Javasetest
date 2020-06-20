package common.java_main;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.*;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TsetTime {

    public static void main(String[] args) throws InterruptedException {


        /**
         * LocalDate ：表示日期，包含年月日，格式为 2019-10-16
         * LocalTime ：表示时间，包含时分秒，格式为 16:38:54.158549300
         * LocalDateTime ：表示日期时间，包含年月日，时分秒，格式为 2018-09-06T15:33:56.750
         * DateTimeFormatter ：日期时间格式化类。
         * Instant：时间戳，表示一个特定的时间瞬间。
         * Duration：用于计算2个时间(LocalTime，时分秒)的距离
         * Period：用于计算2个日期(LocalDate，年月日)的距离
         * ZonedDateTime ：包含时区的时间
         *
         * Java中使用的历法是ISO 8601日历系统，它是世界民用历法，也就是我们所说的公历。平年有365天，闰年是366天。
         * 此外Java 8还提供了4套其他历法，分别是：
         *
         * ThaiBuddhistDate ：泰国佛教历
         * MinguoDate ：中华民国历
         * JapaneseDate ：日本历
         * HijrahDate ：伊斯兰历
         */

        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        System.out.println(between.toMillis());

        Instant start1 = Instant.now();
        Thread.sleep(100);
        Instant end1 = Instant.now();
        Duration between1 = Duration.between(start1, end1);

        //是否快10倍
        boolean negative = between1.multipliedBy(10).minus(between).isNegative();
        System.out.println(negative);


        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate of = LocalDate.of(2020, 2, 19);
        System.out.println(of.toString());
        //加11天
        LocalDate localDate = of.plusDays(11);
        System.out.println(localDate);

        //当前日期加上指定年
        LocalDate localDate1 = localDate.withYear(2019);
        System.out.println(localDate1);
        //指定当前年的第几天
        LocalDate localDate2 = LocalDate.now().withDayOfYear(1);
        System.out.println(localDate2);
        //当前月的指定第几天
        LocalDate localDate3 = LocalDate.now().withDayOfMonth(1);
        System.out.println(localDate3);
        
        
        
        
        //get** api
        System.out.println("get** api-------------");
        IsoChronology chronology = LocalDate.now().getChronology();
        System.out.println(chronology);
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfYear = LocalDate.now().getDayOfYear();
        System.out.println(dayOfYear);


        LocalDate localDate4 = LocalDate.now().withDayOfYear(1);
        LocalDate localDate5 = localDate4.plusDays(255);
        System.out.println(localDate5);

        LocalDate localDate6 = LocalDate.of(2019, 3, 31).minusMonths(1);
        System.out.println(localDate6);

        /**
         * 俩个instant 之间的时长用 duration 计算，本地日期的等价物，period
         */

        long until = LocalDate.now().until(LocalDate.of(2019, 10, 2), ChronoUnit.DAYS);
        System.out.println(until);

        MonthDay now1 = MonthDay.now();
        System.out.println(now1.toString());

        //日期调整器  TemporalAdjusters
        System.out.println("日期调整器------TemporalAdjusters---------------------");
        //给定日期的第一个星期三
        LocalDate localDate7 = weekOfDaySe(2020, 5);
        System.out.println(localDate7);

        //当前月的几个周几
        LocalDate with = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY));
        System.out.println(with);

        //当前月的最后一个星期三
        LocalDate with1 = LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.WEDNESDAY));
        System.out.println(with1);

        //
        LocalDate with2 = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with2);

        //当前月的下个月第一天
        LocalDate with3 = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(with3);


        //自定义调整器,当前日期的下个工作日
        LocalDate with4 = LocalDate.of(2020,5,22).with((w) -> {
            LocalDate w1 = (LocalDate) w;
            do {
                w1 = w1.plusDays(1);
            } while (w1.getDayOfWeek().getValue() >= 6);
            return w1;
        });

        System.out.println(with4);
    }

    private static  LocalDate weekOfDaySe(int year,int month){

        LocalDate with = LocalDate.of(year, month, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
        return with;
    }
}
