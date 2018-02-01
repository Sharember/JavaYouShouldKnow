package cn.fanhub.serialization.xml;

import cn.fanhub.serialization.base.MySerializer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author chengfan
 * @date 2018-1-31 21:08:43
 */
public class JavaXMLSerializer implements MySerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XMLEncoder xmlEncoder = new XMLEncoder(outputStream, "utf-8", true, 0);
        xmlEncoder.writeObject(obj);
        xmlEncoder.close();
        return outputStream.toByteArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(data));
        Object obj = xmlDecoder.readObject();
        xmlDecoder.close();
        return (T) obj;
    }

}