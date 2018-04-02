/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.fanhub.clazz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chengfan
 * @version $Id: Test.java, v 0.1 2018年03月30日 下午9:47 chengfan Exp $
 */
public class Test {

    @org.junit.Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mysql?user=root&password=123456";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url);
        conn.close();

    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
}