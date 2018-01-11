package cn.fanhub.creational.factory;

/**
 * @author chengfan
 * @date 2018-1-12 0:08:46
 */
public class ShapeFactoryGenerics {
    public static <AShape extends Shape> AShape getShape(Class<AShape> clazz) {
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
}