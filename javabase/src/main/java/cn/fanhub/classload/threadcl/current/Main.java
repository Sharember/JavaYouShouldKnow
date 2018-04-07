package cn.fanhub.classload.threadcl.current;

import cn.fanhub.classload.threadcl.parrent.Spi;
import cn.fanhub.classload.threadcl.parrent.SpiManager;

/**
 *
 * @author chengfan
 * @version $Id: Main.java, v 0.1 2018年03月29日 下午9:52 chengfan Exp $
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Main main = new Main();
        main.first();

        System.out.println("-----------");
        main.second();

        //System.out.println("-----------");
        //main.third();
    }

    private void first () throws ClassNotFoundException {
        System.out.println(Spi.class.getClassLoader());
        System.out.println(SpiImpl.class.getClassLoader());
        System.out.println(SpiManager.getConnection().getClassLoader());
    }

    private void second() throws ClassNotFoundException {
        Thread.currentThread().setContextClassLoader(Main.class.getClassLoader());
        System.out.println(Spi.class.getClassLoader());
        System.out.println(SpiImpl.class.getClassLoader());
        System.out.println(SpiManager.getConnection2().getClassLoader());
    }

    private void third() throws ClassNotFoundException {
        System.out.println(SpiManager.getConnection3().getClassLoader());
    }
}
