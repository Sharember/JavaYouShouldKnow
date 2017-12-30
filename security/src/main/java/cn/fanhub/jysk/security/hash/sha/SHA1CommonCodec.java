package cn.fanhub.jysk.security.hash.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author chengfan
 * @date 2017-12-30 10:16:27
 */
public class SHA1CommonCodec {

    public static String sha1Hex(String str) {
        return DigestUtils.sha1Hex(str.getBytes());
    }

    public static byte[] sha1(String str) {
        return DigestUtils.sha1(str.getBytes());
    }

    public static String sha1AndEncodeHexString (String str) {
        return Hex.encodeHexString(DigestUtils.sha1(str.getBytes()));
    }
}