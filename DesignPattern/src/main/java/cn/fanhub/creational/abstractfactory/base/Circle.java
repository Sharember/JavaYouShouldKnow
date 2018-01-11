package cn.fanhub.creational.abstractfactory.base;



/**
 * @author chengfan
 * @date 2018-1-11 23:43:26
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("i am circle");
    }
}