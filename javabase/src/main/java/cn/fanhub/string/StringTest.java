package cn.fanhub.string;

/**
 *
 * @author chengfan
 * @version $Id: StringTest.java, v 0.1 2018年03月23日 下午1:09 chengfan Exp $
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "abcdefg";
        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
        }


        char[] chars = str.toCharArray();
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - start);

        System.out.println("------");
        start = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
        }
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - start);
    }
}