package cn.fanhub.classload.threadcl;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author chengfan
 * @version $Id: Main.java, v 0.1 2018年03月29日 下午9:52 chengfan Exp $
 */
public class Main {
    private String classDataRootPath = "/Users/chengfan/Documents/SelfStudy/java/JavaYouShouldKnow/javabase/src/main/java";
    @Test
    public void Test1()
            throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<Main> mainClass = Main.class;
        System.out.println(Thread.currentThread().getContextClassLoader());
        ClassLoader currentClassloader = Main.class.getClassLoader();

        UserClassloader classloader = new UserClassloader(new URL[]{new File(classDataRootPath).toURI().toURL()}, currentClassloader);

        Spi spi = (Spi) classloader.loadClass("cn.fanhub.classload.threadcl.SpiImpl").newInstance();
    }

    public void test2() {

    }
}