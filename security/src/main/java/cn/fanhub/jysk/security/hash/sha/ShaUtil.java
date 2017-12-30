package cn.fanhub.jysk.security.hash.sha;

public class ShaUtil {
    private final static char[] UPPER_DIGIT = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
            'D', 'E', 'F'
    };
    private final static char[] LOWER_DIGIT = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
            'd', 'e', 'f'
    };
    // 将字节转换为十六进制字符串
    private static String byteToHexString(byte ib, boolean useUpper) {
        char[] Digit = useUpper ? UPPER_DIGIT : LOWER_DIGIT;

        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        return new String(ob);
    }
    // 将字节数组转换为十六进制字符串
    public static String byteArrayToHexString(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (byte b : byteArray) {
            strDigest.append(byteToHexString(b, false));
        }
        return strDigest.toString();
    }
}