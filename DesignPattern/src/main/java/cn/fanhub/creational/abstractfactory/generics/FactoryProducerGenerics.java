package cn.fanhub.creational.abstractfactory.generics;

public class FactoryProducerGenerics {
    public static <Factory extends AbstractFactoryGenerics> Factory getFactory(Class<Factory> clazz) {
        Factory obj = null;
        try {
            obj = (Factory) Class.forName(clazz.getName()).newInstance();
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