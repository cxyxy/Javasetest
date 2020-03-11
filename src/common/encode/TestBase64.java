package common.encode;

import java.util.Base64;

/**
 * User: Amos
 * Date: 2020/3/11
 * Time: 15:15
 */
public class TestBase64 {

    public static void main(String[] args) {
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
    }

}
