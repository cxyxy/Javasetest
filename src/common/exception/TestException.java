package common.exception;

/**
 * User: Amos
 * Date: 2019/4/19
 * Time: 10:44
 */
public class TestException {

    public static int doStuff(int a)throws Exception{

        try {
            if(a>0){
                throw new RuntimeException("数据错误");
            }else {
                return a;
            }
        } catch (RuntimeException e) {
            throw e;
        } finally {
//           a= -1;
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(doStuff(1));
    }
}
