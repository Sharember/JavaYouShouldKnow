package cn.fanhub.jysk.security.hash.sha;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * @author chengfan
 * @date 2017-12-30 10:12:36
 */
public class SHA1Jdk {
    public static byte[] encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encodeAndEncodeHexString(String str) {
        return Hex.encodeHexString(encode(str));
    }
}