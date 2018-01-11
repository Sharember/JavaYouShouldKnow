package cn.fanhub.creational.factory;

/**
 * @author chengfan
 * @date 2018-1-11 23:43:30
 */
public class ShapeFactory {
    public static Object getShape(Class<? extends Shape> clazz)  {
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