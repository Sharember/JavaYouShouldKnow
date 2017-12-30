package cn.fanhub.jysk.security.hash.sha;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * @author chengfan
 * @date 2017-12-30 10:22:07
 */
public class SHA1Test {

    private static String testStr = "abc";

    @Test
    public void SHA1CommonCodecTest() {
        System.out.println("+--------------------SHA1CommonCodec.sha1Hex------------------------+");
        System.out.println(SHA1CommonCodec.sha1Hex(testStr));
        System.out.println();

        System.out.println("+--------------------SHA1CommonCodec.sha1------------------------+");
        for (byte b : SHA1CommonCodec.sha1(testStr)) {
            System.out.print(b);
        }
        System.out.println(); System.out.println();

        System.out.println("+--------------------SHA1CommonCodec.sha1AndEncodeHexString------------------------+");
        System.out.println(SHA1CommonCodec.sha1AndEncodeHexString(testStr));
        System.out.println();
    }

    @Test
    public void SHA1JdkTest() {
        System.out.println("+--------------------SHA1Jdk.encode------------------------+");
        for (byte b : SHA1Jdk.encode(testStr)) {
            System.out.print(b);
        }
        System.out.println();System.out.println();

        System.out.println("+--------------------SHA1Jdk.encodeAndEncodeHexString------------------------+");
        System.out.println(SHA1Jdk.encodeAndEncodeHexString(testStr));
        System.out.println();
    }

    @Test
    public void SHA1SelfTest() {
        SHA1Self sha1Self = new SHA1Self();
        System.out.println("+--------------------SHA1Self.getDigestOfBytes------------------------+");
        for (byte b : sha1Self.getDigestOfBytes(testStr.getBytes())) {
            System.out.print(b);
        }
        System.out.println();System.out.println();

        System.out.println("+--------------------SHA1Self.getDigestOfString by ShaUtil------------------------+");
        System.out.println(sha1Self.getDigestOfString(testStr.getBytes()));
        System.out.println();

        System.out.println("+--------------------SHA1Self.getDigestOfString by common-codec encodeHexString------------------------+");
        System.out.println(Hex.encodeHexString(sha1Self.getDigestOfBytes(testStr.getBytes())));
        System.out.println();
    }

    /** 结果
     +--------------------SHA1CommonCodec.sha1Hex------------------------+
     a9993e364706816aba3e25717850c26c9cd0d89d

     +--------------------SHA1CommonCodec.sha1------------------------+
     -87-1036254716-127106-70623711312080-62108-100-48-40-99

     +--------------------SHA1CommonCodec.sha1AndEncodeHexString------------------------+
     a9993e364706816aba3e25717850c26c9cd0d89d

     +--------------------SHA1Self.getDigestOfBytes------------------------+
     -87-1036254716-127106-70623711312080-62108-100-48-40-99

     +--------------------SHA1Self.getDigestOfString by ShaUtil------------------------+
     a9993e364706816aba3e25717850c26c9cd0d89d

     +--------------------SHA1Self.getDigestOfString by common-codec encodeHexString------------------------+
     a9993e364706816aba3e25717850c26c9cd0d89d

     +--------------------SHA1Jdk.encode------------------------+
     -87-1036254716-127106-70623711312080-62108-100-48-40-99

     +--------------------SHA1Jdk.encodeAndEncodeHexString------------------------+
     a9993e364706816aba3e25717850c26c9cd0d89d
     */
}