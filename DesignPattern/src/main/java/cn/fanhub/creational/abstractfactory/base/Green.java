package cn.fanhub.creational.abstractfactory.base;

/**
 * @author chengfan
 * @date 2018-1-11 23:50:33
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("fill green");
    }
}