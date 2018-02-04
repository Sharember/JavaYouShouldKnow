package cn.fanhub.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class GetFields {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Class baseModel = Class.forName("cn.fanhub.reflect.BaseModel");
        Object obj = baseModel.getConstructor().newInstance();
        Method[] methods = baseModel.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Type[] types = method.getGenericParameterTypes();
            Class<?>[] paramClass = new Class[types.length];
            Object[] params = new Object[types.length];
            for (int i = 0; i < types.length; i++) {
                System.out.println(types[i].getTypeName());
                paramClass[i] = Class.forName(types[i].getTypeName());
                params[i] = setParamValue(types[i]);

            }
            Method invokeMethod = baseModel.getDeclaredMethod(method.getName(), paramClass);

            invokeMethod.invoke(obj, params);

        }

    }

    private static Object setParamValue(Type type) {
        switch (type.getTypeName()) {
            case "java.lang.String":
                return "hhh";
            case "java.lang.Integer":
                return 1;
            default:
                return "";
        }
    }

}