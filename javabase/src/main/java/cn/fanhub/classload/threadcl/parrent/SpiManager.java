/**
 * Fanhub.cn
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package cn.fanhub.classload.threadcl.parrent;

/**
 *
 * @author chengfan
 * @version $Id: SpiManager.java, v 0.1 2018年04月04日 下午8:58 chengfan Exp $
 */
public class SpiManager {

    public static Class<?> getConnection() throws ClassNotFoundException {
        return Class.forName("cn.fanhub.classload.threadcl.current.SpiImpl");
    }

    public static Class<?> getConnection2() throws ClassNotFoundException {
        return Class.forName("cn.fanhub.classload.threadcl.current.SpiImpl", true, Thread.currentThread().getContextClassLoader());
    }

    public static Class<?> getConnection3() throws ClassNotFoundException {
        return Class.forName("cn.fanhub.classload.threadcl.current.SpiImpl", true, ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}