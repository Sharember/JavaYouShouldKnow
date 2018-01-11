package cn.fanhub.creational.abstractfactory;

import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Shape;

public abstract class AbstractFactory {
    public abstract Object getColor(Class<? extends Color> clazz);
    public abstract Object getShape(Class<? extends Shape> clazz);
}