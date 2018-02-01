package cn.fanhub.serialization;

import cn.fanhub.serialization.java.JavaSerialization;
import cn.fanhub.serialization.json.JsonSerializer;
import cn.fanhub.serialization.xml.JavaXMLSerializer;
import cn.fanhub.serialization.xml.XStreamXMLSerializer;
import org.junit.Test;

public class SerializerTest {

    @Test
    public void testJava() {
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

    @Test
    public void testJavaXML() {
        JavaXMLSerializer javaXMLSerializer = new JavaXMLSerializer();
        JavaSerializerModel serializerModel = new JavaSerializerModel();
        JavaSerializerModel model = javaXMLSerializer.deserialize(javaXMLSerializer.serialize(serializerModel), JavaSerializerModel.class);
        System.out.println(model.getName());
        System.out.println(model.getPhone());
        System.out.println(model.getDate());
    }

    @Test
    public void testXStreamXML() {
        XStreamXMLSerializer xstreamXMLSerializer = new XStreamXMLSerializer();
        JavaSerializerModel serializerModel = new JavaSerializerModel();
        JavaSerializerModel model = xstreamXMLSerializer.deserialize(xstreamXMLSerializer.serialize(serializerModel), JavaSerializerModel.class);
        System.out.println(model.getName());
        System.out.println(model.getPhone());

        System.out.println("----2-----");
        JavaSerializerModel2 serializerModel2 = new JavaSerializerModel2();
        JavaSerializerModel2 model2 = xstreamXMLSerializer.deserialize(xstreamXMLSerializer.serialize(serializerModel2), JavaSerializerModel2.class);
        System.out.println(model2.getName());
        System.out.println(model2.getPhone());
        System.out.println(model.getDate());
    }


    @Test
    public void testJson() {
        JsonSerializer jsonSerializer = new JsonSerializer();
        JavaSerializerModel serializerModel = new JavaSerializerModel();
        JavaSerializerModel model = jsonSerializer.deserialize(jsonSerializer.serialize(serializerModel), JavaSerializerModel.class);
        System.out.println(model.getName());
        System.out.println(model.getPhone());
        System.out.println(model.getDate());
    }

}