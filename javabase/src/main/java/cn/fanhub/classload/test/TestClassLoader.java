/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.fanhub.classload.test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author chengfan
 * @version $Id: TestClassLoader.java, v 0.1 2018年03月28日 下午2:39 chengfan Exp $
 */
public class TestClassLoader extends URLClassLoader{
    public TestClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        if (name.contains("ClassA")) {
            Class clazz = findClass(name);

            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }

        return super.loadClass(name, resolve);
    }


}