package cn.fanhub.creational.abstractfactory.generics;

import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Shape;

/**
 * @author chengfan
 * @date 2018-1-12 0:08:46
 */
public class ShapeFactoryGenerics extends AbstractFactoryGenerics{
    @Override
    public  <AShape extends Shape> AShape getShape(Class<AShape> clazz) {
        AShape obj = null;
        try {
            obj = (AShape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public <AColor extends Color> AColor getColor(Class<AColor> clazz) {
        return null;
    }

}