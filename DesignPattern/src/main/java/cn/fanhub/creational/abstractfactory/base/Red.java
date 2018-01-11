package cn.fanhub.creational.abstractfactory.base;

/**
 * @author chengfan
 * @date 2018-1-11 23:49:40
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("fill red");
    }
}