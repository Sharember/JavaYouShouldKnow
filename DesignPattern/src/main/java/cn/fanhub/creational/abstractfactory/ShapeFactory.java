package cn.fanhub.creational.abstractfactory;

import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Shape;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Object getColor(Class<? extends Color> clazz) {
        return null;
    }

    @Override
    public Object getShape(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
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