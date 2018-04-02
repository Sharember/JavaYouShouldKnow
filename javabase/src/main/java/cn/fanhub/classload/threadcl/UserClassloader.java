package cn.fanhub.classload.threadcl;

import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author chengfan
 * @version $Id: UserClassloader.java, v 0.1 2018年03月29日 下午9:51 chengfan Exp $
 */
public class UserClassloader extends URLClassLoader{

    public UserClassloader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {


        if (name.contains("Spi")) {
            Class clazz = findClass(name);

            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
        return super.loadClass(name, resolve);
    }
}