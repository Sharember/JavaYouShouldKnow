package cn.fanhub.creational.abstractfactory.generics;

import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Shape;

/**
 * @author chengfan
 * @date 2018-1-12 0:22:16
 */
public class ColorFactoryGenerics extends AbstractFactoryGenerics{
    @Override
    public <AShape extends Shape> AShape getShape(Class<AShape> clazz) {
        return null;
    }

    @Override
    public <AColor extends Color> AColor getColor(Class<AColor> clazz) {
        AColor obj = null;
        try {
            obj = (AColor) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}