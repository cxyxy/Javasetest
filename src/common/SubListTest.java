package common;

/**
 * User: Amos
 * Date: 2019/4/15
 * Time: 14:00
 */
public class SubListTest {

    /**
     * 主要在子list上的操作,都会体现在父list 上 ，自list是一个视图.
     * @param args
     */
    public static void main(String[] args) {
//        List lsit = new ArrayList<>();
//        lsit.add(1);
//        lsit.add(2);
//        lsit.add(3);
//        System.out.println(lsit);
//        List list = lsit.subList(0, 2);
////        lsit.add(6);
//        System.out.println(list);
//        list.add(4);
//        System.out.println(lsit);
//        System.out.println(list);

        String A="3    ,\n" +
                "5    ,\n" +
                "16884,\n" +
                "1    ,\n" +
                "16919,\n" +
                "11   ,\n" +
                "2005 ,\n" +
                "13680,\n" +
                "16921,\n" +
                "6    ,\n" +
                "16918,\n" +
                "16926,\n" +
                "16930,\n" +
                "16917,\n" +
                "16916,\n" +
                "16915,\n" +
                "16923,\n" +
                "12856,\n" +
                "16922,\n" +
                "12833,\n" +
                "13679,\n" +
                "16931,\n" +
                "4    ,\n" +
                "16929,\n" +
                "12240,\n" +
                "2    ,\n" +
                "16927,\n" +
                "8    ,\n" +
                "16920,\n" +
                "16928,\n" +
                "11256,\n" +
                "10   ,\n" +
                "16925,\n" +
                "16924,\n" +
                "16932";
        String[] split = A.split(",");

        for (String catId:split){
            System.out.println(catId);
        }
    }
}
