package cn.fanhub.classload.threadcl.current;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author chengfan
 * @version $Id: UserClassloader.java, v 0.1 2018年03月29日 下午9:51 chengfan Exp $
 */
public class UserClassloader extends URLClassLoader {
    public UserClassloader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public UserClassloader(ClassLoader classLoader) throws MalformedURLException {
        super(new URL[]{Thread.currentThread().getContextClassLoader().getResource("")}, classLoader);

    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.contains("cn.fanhub.classload.threadcl.current.SpiImpl") || name.contains("Main")) {
            Class clazz = loadClassForOverriding(name);

            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
        return super.loadClass(name, resolve);
    }

    private Class loadClassForOverriding(String name) throws ClassNotFoundException {
        //查找已加载的类
        Class<?> result = findLoadedClass(name);
        if (result == null) {
            //加载类
            result = findClass(name);
        }
        return result;
    }
}