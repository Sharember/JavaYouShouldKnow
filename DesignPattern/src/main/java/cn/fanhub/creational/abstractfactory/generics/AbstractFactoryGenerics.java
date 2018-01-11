package cn.fanhub.creational.abstractfactory.generics;

import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Shape;

/**
 * @author chengfan
 * @date 2018-1-12 0:19:35
 */
public abstract class AbstractFactoryGenerics {
    public abstract <AShape extends Shape> AShape getShape(Class<AShape> clazz);
    public abstract <AColor extends Color> AColor getColor(Class<AColor> clazz);
}