package cn.fanhub.creational.abstractfactory;

import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Object getColor(Class<? extends Color> clazz) {
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

    @Override
    public Shape getShape(Class<? extends Shape> clazz) {
        return null;
    }
}