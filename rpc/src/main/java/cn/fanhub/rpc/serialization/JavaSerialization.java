package cn.fanhub.rpc.serialization;

import cn.fanhub.rpc.serialization.base.JavaSerializerModel;
import cn.fanhub.rpc.serialization.base.JavaSerializerModel2;
import cn.fanhub.rpc.serialization.base.MySerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerialization implements MySerializer{

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream= new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        JavaSerialization javaSerialization = new JavaSerialization();
        JavaSerializerModel serializerModel = new JavaSerializerModel();
        JavaSerializerModel model = javaSerialization.deserialize(javaSerialization.serialize(serializerModel), JavaSerializerModel.class);

        System.out.println(model.getName());
        System.out.println(model.getPhone());

        System.out.println("------model2--------");

        JavaSerializerModel2 serializerModel2 = new JavaSerializerModel2();
        JavaSerializerModel2 model2 = javaSerialization.deserialize(javaSerialization.serialize(serializerModel2), JavaSerializerModel2.class);

        System.out.println(model2.getName());
        System.out.println(model2.getPhone());
    }
}